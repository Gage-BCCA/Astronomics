package com.failedalgorithm.astronomics.game.jobs;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.building_storage.BuildingStorage;
import com.failedalgorithm.astronomics.game.buildings.building_storage.BuildingStorageRepository;
import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.game.items.ItemRepository;
import com.failedalgorithm.astronomics.game.jobs.attached_resources.AttachedResources;
import com.failedalgorithm.astronomics.game.jobs.attached_resources.AttachedResourcesRepository;
import com.failedalgorithm.astronomics.game.jobs.job_queue.JobQueue;
import com.failedalgorithm.astronomics.game.jobs.job_queue.JobQueueRepository;
import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobNotFoundResponse;
import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.game.jobs.requests.JobCreationRequest;
import com.failedalgorithm.astronomics.game.jobs.responses.GenericErrorResponse;
import com.failedalgorithm.astronomics.game.jobs.responses.JobCreatedResponse;
import com.failedalgorithm.astronomics.game.jobs.responses.JobResponse;
import com.failedalgorithm.astronomics.game.jobs.types.JobFactory;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.plots.PlotRepository;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.ZoneRepository;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class JobService
{

    //region Injected Services
    //-----------------------------------
    @Autowired
    JobRepository repository;

    @Autowired
    JobQueueRepository jobQueueRepository;

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobFactory factory;

    @Autowired
    AttachedResourcesRepository attachedResourcesRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    BuildingStorageRepository buildingStorageRepository;
    //-----------------------------------
    //endregion

    public JobResponse createJob(JobCreationRequest request)
    {
        //region Grabbing requesting user and basic error checking
        //-----------------------------------
        Optional<User> userQuery = userRepository.findById(request.getUserId());
        if (userQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "User not found");
        }
        //-----------------------------------
        //endregion

        //region Grabbing involved zones and basic error checking
        //-----------------------------------
        Optional<Zone> originZoneQuery = zoneRepository.findByCoordinates(request.getJobOriginZoneX(),
                request.getJobOriginZoneY());
        if (originZoneQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "Origin zone not found");
        }

        Optional<Zone> targetZoneQuery = zoneRepository.findByCoordinates(request.getTargetZoneX(),
                request.getTargetZoneY());
        if (targetZoneQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "Target zone not found.");
        }
        //-----------------------------------
        //endregion

        //region Grabbing involved plots and basic error checking
        //-----------------------------------
        Optional<Plot> originPlotQuery = plotRepository.findByXAndYAndZone(request.getJobOriginPlotX(),
                request.getJobOriginPlotY(),
                originZoneQuery.get());
        if (originPlotQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "Origin plot not found");
        }

        Optional<Plot> targetPlotQuery = plotRepository.findByXAndYAndZone(request.getTargetPlotX(),
                request.getTargetPlotY(),
                targetZoneQuery.get());
        if (targetPlotQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "Target plot not found");
        }
        //-----------------------------------
        //endregion

        //region Grabbing involved buildings and basic error checking
        //-----------------------------------
        Building originBuilding = originPlotQuery.get().getBuilding();
        if (originBuilding == null)
        {
            return new GenericErrorResponse("Failed", "Origin plot does not contain a building");
        }

        Building targetBuilding = targetPlotQuery.get().getBuilding();
        if (targetBuilding == null)
        {
            return new GenericErrorResponse("Failed", "Target plot does not contain a building");
        }

        if (originBuilding.getOwner().getId() != userQuery.get().getId())
        {
            return new GenericErrorResponse("Failed", "You do not own the origin building");
        }

        if (targetBuilding.getOwner().getId() != userQuery.get().getId())
        {
            return new GenericErrorResponse("Failed", "You do not own the target building");
        }
        //-----------------------------------
        //endregion

        //region Constructing job object
        //-----------------------------------
        Job job = factory.createJobClass(request.getJobType());
        job.setJobCreationTime(new Date());
        job.setOriginZone(originZoneQuery.get());
        job.setTargetZone(targetZoneQuery.get());
        job.setOriginPlot(originPlotQuery.get());
        job.setTargetPlot(targetPlotQuery.get());
        job.setOriginBuilding(originBuilding);
        job.setTargetBuilding(targetBuilding);
        job.setStatus("IN_PROGRESS");
        job.setOwner(userQuery.get());
        job = repository.save(job);
        //-----------------------------------
        //endregion

        //region Creating attached resources objects for persistence
        //-----------------------------------
        // Let's persist the resources by storing them on a separate table
        // Every job should have some sort of item attached to it, so this should
        // be fine...
        ArrayList<AttachedResources> jobResources = new ArrayList<>();
        for (Map.Entry<String, Integer> item : request.getResources().entrySet())
        {
            AttachedResources attachedResources = new AttachedResources();
            Optional<Item> itemQuery = itemRepository.findByItemType(item.getKey());
            if (itemQuery.isEmpty())
            {
                return new GenericErrorResponse("Failed", "Could not locate item: " + item.getKey());
            }
            attachedResources.setItem(itemQuery.get());
            attachedResources.setJob(job);


            attachedResources.setAmount(item.getValue());
            jobResources.add(attachedResources);
        }
        //-----------------------------------
        //endregion

        //region Checking for proper amounts in building storage to complete job
        //-----------------------------------
        // Before saving the resources, we need to iterate through and make sure that
        // the target building has enough resources to complete this task
        Iterable<BuildingStorage> originBuildingItemsStored = buildingStorageRepository.findByBuildingId(originBuilding.getId());
        for (AttachedResources resource : jobResources)
        {
            boolean resourceFound = false;
            for (BuildingStorage storedResource : originBuildingItemsStored)
            {
                if (resource.getItem().getId() == storedResource.getItem().getId())
                {
                    if (resource.getAmount() > storedResource.getAmount())
                    {
                        return new GenericErrorResponse("Failed",
                                "Not enough present in origin building of type: "
                                        + resource.getItem().getItemName());

                    }
                    resourceFound = true;
                    break;
                }
            }

            if (!resourceFound)
            {
                return new GenericErrorResponse("Failed", "Resource not found in origin building: "
                        + resource.getItem().getItemName());
            }
        }
        //-----------------------------------
        //endregion

        //region Saving attached resources objects
        //-----------------------------------
        attachedResourcesRepository.saveAll(jobResources);
        //-----------------------------------
        //endregion

        //region Save to Job Queue
        //-----------------------------------
        JobQueue jobQueueEntry = new JobQueue();
        jobQueueEntry.setJob(job);
        jobQueueRepository.save(jobQueueEntry);
        //-----------------------------------
        //endregion

        return new JobCreatedResponse(job);
    }

    public JobResultResponse executeJob(Long id)
    {
        Optional<Job> targetJob = repository.findById(id);
        if (targetJob.isPresent())
        {
            return targetJob.get().executeJob();
        }
        else
        {
            JobNotFoundResponse response = new JobNotFoundResponse();
            response.setMessage("Error executing job.");
            return response;
        }
    }
}

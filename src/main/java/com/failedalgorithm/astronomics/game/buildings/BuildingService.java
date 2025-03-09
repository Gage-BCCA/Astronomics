package com.failedalgorithm.astronomics.game.buildings;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.building_storage.BuildingStorage;
import com.failedalgorithm.astronomics.game.buildings.building_storage.BuildingStorageRepository;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingCreationRequest;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingDeleteRequest;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingProduceRequest;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingUpdateRequest;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.failedalgorithm.astronomics.game.buildings.responses.errors.BuildingGenericErrorResponse;
import com.failedalgorithm.astronomics.game.buildings.responses.errors.BuildingNotFoundResponse;
import com.failedalgorithm.astronomics.game.buildings.responses.successes.*;
import com.failedalgorithm.astronomics.game.buildings.types.BuildingTypeFactory;
import com.failedalgorithm.astronomics.game.buildings.types.produced_items.ProducedItem;
import com.failedalgorithm.astronomics.game.buildings.types.produced_items.ProducedItemRepository;
import com.failedalgorithm.astronomics.game.colonies.Colony;
import com.failedalgorithm.astronomics.game.colonies.ColonyRepository;
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
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService
{

    //================================================================================
    // Injected Services
    //================================================================================
    @Autowired
    BuildingRepository repository;

    @Autowired
    BuildingTypeFactory factory;

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ColonyRepository colonyRepository;

    @Autowired
    BuildingStorageRepository buildingStorageRepository;

    @Autowired
    ProducedItemRepository producedItemRepository;


    //================================================================================
    // Services
    //================================================================================

    //region Getters
    //-----------------------------------------
    public BuildingResponse getBuildingById(Long id)
    {
        Optional<Building> buildingQuery = repository.findById(id);
        if (buildingQuery.isEmpty())
        {
            return new BuildingNotFoundResponse();
        }
        return new BuildingFoundResponse(new BuildingDetailsDTO(buildingQuery.get()));
    }

    public Iterable<BuildingDetailsDTO> getAllBuildings()
    {
        Iterable<Building> buildings = repository.findAll();
        List<BuildingDetailsDTO> buildingDTOs = new ArrayList<>();
        for (Building building : buildings)
        {
            buildingDTOs.add(new BuildingDetailsDTO(building));
        }

        return buildingDTOs;
    }
    //-----------------------------------------
    //endregion

    //region Creators
    //-----------------------------------------
    public BuildingResponse createBuilding(BuildingCreationRequest request)
    {
        //region Getting target zone
        //-----------------------------------
        Optional<Zone> zoneQuery = zoneRepository.findByCoordinates(request.getZoneX(), request.getZoneY());
        Zone zone;
        if (zoneQuery.isPresent())
        {
            zone = zoneQuery.get();
        }
        else
        {
            return new BuildingGenericErrorResponse("Could not find zone.");
        }
        //-----------------------------------
        //endregion

        //region Getting target plot
        //-----------------------------------
        Optional<Plot> plotQuery = plotRepository.findByXAndYAndZone(request.getPlotX(), request.getPlotY(), zone);
        Plot plot;
        if (plotQuery.isPresent())
        {
            plot = plotQuery.get();
            if (plot.isOccupied())
            {
                return new BuildingGenericErrorResponse("Plot is already occupied");
            }
        }
        else
        {
            return new BuildingGenericErrorResponse("Could not find plot.");
        }
        //-----------------------------------
        //endregion

        //region Getting requesting user
        //-----------------------------------
        Optional<User> userQuery = userRepository.findById(request.getUserId());
        User user;
        if (userQuery.isPresent())
        {
            user = userQuery.get();
        }
        else
        {
            return new BuildingGenericErrorResponse("Could not find user.");
        }
        //-----------------------------------
        //endregion

        //region Getting user's colony
        //-----------------------------------
        Optional<Colony> colonyQuery = colonyRepository.findByOwner(user);
        Colony colony;
        if (colonyQuery.isEmpty())
        {
            return new BuildingGenericErrorResponse("Could not find colony.");
        }
        colony = colonyQuery.get();
        //-----------------------------------
        //endregion

        //region Constructing new Building object
        //-----------------------------------
        Building newBuilding = factory.createBuildingClass(request.getBuildingType());
        newBuilding.setCraftSpeed();
        newBuilding.setMaxStorage();
        newBuilding.setBuildingIdentifier(request.getBuildingIdentifier());
        newBuilding.setZone(zone);
        newBuilding.setPlot(plot);
        newBuilding.setOwner(user);
        newBuilding.setColony(colony);
        newBuilding.setDateCreated(new Date());
        newBuilding.setLastModifiedTimestamp(new Date());
        newBuilding.setLastProductionTimestamp(new Date());

        Optional<ProducedItem> producedItem = producedItemRepository.findByBuildingType(request.getBuildingType());
        if (producedItem.isEmpty())
        {
            return new BuildingGenericErrorResponse("Internal Error. Shit's _real_ broke.");
        }
        newBuilding.setItem(producedItem.get().getItem());
        repository.save(newBuilding);
        //-----------------------------------
        //endregion

        //region Altering target plot properties
        //-----------------------------------
        plot.setOccupied(true);
        plot.setBuilding(newBuilding);
        plotRepository.save(plot);
        //-----------------------------------
        //endregion

        return new BuildingCreatedResponse("Success", "Successfully built", new BuildingDetailsDTO(newBuilding));
    }

    public Building createInitialCommandCenter(Zone zone, Plot plot, Colony colony, User user)
    {
        //region Constructing new Building object
        //-----------------------------------
        Building newBuilding = factory.createBuildingClass("COMMAND_CENTER");
        newBuilding.setCraftSpeed();
        newBuilding.setMaxStorage();
        newBuilding.setBuildingIdentifier(colony.getColonyName() + "-HQ1");
        newBuilding.setZone(zone);
        newBuilding.setPlot(plot);
        newBuilding.setOwner(user);
        newBuilding.setColony(colony);
        newBuilding.setDateCreated(new Date());
        newBuilding.setLastModifiedTimestamp(new Date());
        newBuilding.setLastProductionTimestamp(new Date());
        newBuilding.setBuilt(true);
        newBuilding.setActive(true);
        newBuilding = repository.save(newBuilding);
        //-----------------------------------
        //endregion

        //region Altering target plot properties
        //-----------------------------------
        plot.setOccupied(true);
        plot.setBuilding(newBuilding);
        plotRepository.save(plot);
        //-----------------------------------
        //endregion

        //region Setting up starter BuildingStorage entries
        //-----------------------------------

        //-----------------------------------
        //endregion

        return newBuilding;
    }
    //-----------------------------------------
    //endregion

    //region Deleters
    //-----------------------------------------
    public BuildingResponse deleteBuildingById(BuildingDeleteRequest request)
    {
        Optional<Building> buildingQuery = repository.findById(request.getBuildingId());
        if (buildingQuery.isEmpty())
        {
            return new BuildingNotFoundResponse();
        }
        Building building = buildingQuery.get();

        building.getPlot().setBuilding(null);
        plotRepository.save(building.getPlot());
        repository.delete(building);
        return new BuildingDeletedResponse();
    }
    //-----------------------------------------
    //endregion

    //region Updaters
    //-----------------------------------------
    public BuildingResponse updateBuildingById(BuildingUpdateRequest request)
    {
        Optional<Building> buildingQuery = repository.findById(request.getBuildingId());
        if (buildingQuery.isEmpty())
        {
            return new BuildingNotFoundResponse();
        }
        Building building = buildingQuery.get();
        building.setBuildingIdentifier(request.getNewIdentifier());
        repository.save(building);
        return new BuildingUpdatedResponse();
    }
    //-----------------------------------------
    //endregion

    //region Interactions
    //-----------------------------------------
    public BuildingResponse invokeProduction(BuildingProduceRequest request)
    {
        Optional<Building> buildingQuery = repository.findById(request.getBuildingId());
        if (buildingQuery.isEmpty())
        {
            return new BuildingNotFoundResponse();
        }
        Building building = buildingQuery.get();
        Long resourcesGathered = building.produce();
        Optional<BuildingStorage> storageEntryQuery = buildingStorageRepository.findByBuildingIdAndItemId(building.getId(), building.getItem().getId());
        if (storageEntryQuery.isPresent())
        {
            BuildingStorage storageEntry = storageEntryQuery.get();
            storageEntry.setAmount(storageEntry.getAmount() + resourcesGathered);
            buildingStorageRepository.save(storageEntry);
        }
        else
        {
            BuildingStorage storageEntry = new BuildingStorage();
            storageEntry.setItem(building.getItem());
            storageEntry.setBuilding(building);
            storageEntry.setAmount(resourcesGathered);
            buildingStorageRepository.save(storageEntry);
        }
        return new BuildingProductionInvokedResponse(resourcesGathered);
    }
    //-----------------------------------------
    //endregion

}

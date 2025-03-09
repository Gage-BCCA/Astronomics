package com.failedalgorithm.astronomics.game.colonies;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.BuildingService;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyCreateRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyDeleteRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyReadRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyUpdateRequest;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationFailureResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationSuccessResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteFailedResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteSuccessResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadByOwnerResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadFailedResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateFailedResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateSuccessResponse;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.plots.PlotService;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.ZoneService;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.users.UserRepository;
import com.failedalgorithm.astronomics.users.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ColonyService
{

    //================================================================================
    // Injected Properties
    //================================================================================
    @Autowired
    ColonyRepository repository;

    @Autowired
    UserService userService;

    @Autowired
    ZoneService zoneService;

    @Autowired
    PlotService plotService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    UserRepository userRepository;


    //================================================================================
    // Services
    //================================================================================

    //region Getters
    //-----------------------------------------
    public Iterable<Colony> getAllColonies()
    {
        return repository.findAll();
    }

    public ColonyReadResponse getIndividualColony(ColonyReadRequest request)
    {
        Optional<User> owner = userRepository.findById(request.getUserId());
        if (owner.isEmpty())
        {
            return new ColonyReadFailedResponse("Failed", "Calling agent does not have a colony associated with it");
        }
        Optional<Colony> colonyQuery = repository.findByOwner(owner.get());
        if (colonyQuery.isEmpty())
        {
            return new ColonyReadFailedResponse("Failed", "Colony not found.");
        }
        Colony colony = colonyQuery.get();
        Hibernate.initialize(colony);
        return new ColonyReadByOwnerResponse("Success", "Colony located", colony);
    }
    //-----------------------------------------
    //endregion

    //region Creators
    //-----------------------------------------
    public ColonyFoundationResponse foundNewColony(ColonyCreateRequest request)
    {
        User targetUser = userService.getById(request.getUserId());
        if (targetUser == null)
        {
            return new ColonyFoundationFailureResponse("Failure", "User Not Found");
        }
        Optional<Colony> colonyQuery = repository.findByOwner(targetUser);
        if (colonyQuery.isPresent())
        {
            return new ColonyFoundationFailureResponse("Failure", "User already has a colony.");
        }

        Zone targetZone = zoneService.getZoneObjectByCoordinates(request.getZoneX(), request.getZoneY());
        if (targetZone == null)
        {
            return new ColonyFoundationFailureResponse("Failure", "Zone Not Found");
        }

        Plot targetPlot = plotService.getPlotObjectByCoordinates(request.getPlotX(), request.getPlotY(), targetZone);
        if (targetPlot == null)
        {
            return new ColonyFoundationFailureResponse("Failure", "Plot Not Found");
        }
        if (targetPlot.isOccupied())
        {
            return new ColonyFoundationFailureResponse("Failure", "Plot already has a building");
        }

        // Create new colony object and adjust
        Colony newColony = new Colony();
        newColony.setColonyName(request.getColonyName());
        newColony.setOwner(targetUser);
        newColony.setZone(targetZone);
        newColony.setPlot(targetPlot);
        newColony = repository.save(newColony);

        Building newCommandCenter = buildingService.createInitialCommandCenter(targetZone, targetPlot,
                newColony, targetUser);
        // Adjust plot object
        targetPlot = plotService.updatePlotWithBuilding(newCommandCenter, targetPlot);

        return new ColonyFoundationSuccessResponse("Success",
                "Your colony has been founded.",
                newColony);
    }
    //-----------------------------------------
    //endregion

    //region Updaters
    //-----------------------------------------
    public ColonyUpdateResponse updateColony(ColonyUpdateRequest request)
    {
        Optional<Colony> targetColony = repository.findByColonyName(request.getColonyName());
        if (targetColony.isEmpty())
        {
            return new ColonyUpdateFailedResponse("Failed", "Colony not found");
        }

        Optional<User> userQuery = userRepository.findById(request.getUserId());
        if (userQuery.isEmpty())
        {
            return new ColonyUpdateFailedResponse("Failed", "No user found for calling agent");
        }

        if (userQuery.get().getId() != targetColony.get().getOwner().getId())
        {
            return new ColonyUpdateFailedResponse("Failed", "Calling agent does not match colony owner");
        }

        Colony colony = targetColony.get();
        colony.setColonyName(request.getNewName());
        colony = repository.save(colony);
        ColonyUpdateSuccessResponse success = new ColonyUpdateSuccessResponse();
        success.setMessage("Colony Updated");
        success.setStatus("Success");
        success.setColony(colony);
        return success;
    }
    //-----------------------------------------
    //endregion

    //region Deleters
    //-----------------------------------------
    public ColonyDeleteResponse deleteColony(ColonyDeleteRequest request)
    {
        Optional<Colony> colonyQuery = repository.findByColonyName(request.getColonyName());
        if (colonyQuery.isEmpty())
        {
            return new ColonyDeleteFailedResponse("Failed", "Could not find colony");
        }

        Optional<User> userQuery = userRepository.findById(request.getUserId());
        if (userQuery.isEmpty())
        {
            return new ColonyDeleteFailedResponse("Failed",
                    "No user found for calling agent");
        }

        if (!Objects.equals(colonyQuery.get().getOwner().getId(), userQuery.get().getId()))
        {
            return new ColonyDeleteFailedResponse("Failed",
                    "Calling agent id does not match colony owner's id");
        }

        repository.delete(colonyQuery.get());
        return new ColonyDeleteSuccessResponse("Success", "Colony successfully deleted");
    }
    //-----------------------------------------
    //endregion

}

package com.failedalgorithm.astronomics.game.colonies;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.BuildingService;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyDeleteRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyReadRequest;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyUpdateRequest;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteFailedResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.delete.ColonyDeleteSuccessResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadByOwnerResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadFailedResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.read.ColonyReadResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateFailedResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.update.ColonyUpdateSuccessResponse;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.users.UserService;
import com.failedalgorithm.astronomics.game.colonies.requests.ColonyCreateRequest;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationFailureResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationResponse;
import com.failedalgorithm.astronomics.game.colonies.responses.create.ColonyFoundationSuccessResponse;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.plots.PlotService;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<Colony> colonyQuery = repository.findByColonyName(request.getColonyName());
        if (colonyQuery.isEmpty())
        {
            return new ColonyReadFailedResponse("Failed", "Colony not found.");
        }
        Colony colony = colonyQuery.get();
        return new ColonyReadByOwnerResponse("Success", "Colony located", colony);
    }
    //-----------------------------------------
    //endregion

    //region Creators
    //-----------------------------------------
    public ColonyFoundationResponse foundNewColony(ColonyCreateRequest request)
    {
        // TODO: make sure plot is not occupied with building
        // TODO: make sure user does not have a colony
        User targetUser = userService.getById(request.getUserId());
        if (targetUser == null)
        {
            return new ColonyFoundationFailureResponse("Failure", "User Not Found");
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

        Building newCommandCenter = buildingService.createInitialCommandCenter(targetZone, targetPlot,
                                                                               request.getColonyName(), targetUser);
        // Adjust plot object
        targetPlot = plotService.updatePlotWithBuilding(newCommandCenter, targetPlot);

        // Create new colony object and adjust
        Colony newColony = new Colony();
        newColony.setColonyName(request.getColonyName());
        newColony.setOwner(targetUser);
        newColony.setZone(targetZone);
        newColony.setPlot(targetPlot);
        newColony = repository.save(newColony);
        // TODO: Construct colony DTO instead of passing raw Colony
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
        // TODO: Check if colony owner is the same user making request
        Colony colony = targetColony.get();
        colony.setColonyName(request.getColonyName());
        repository.save(targetColony.get());
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
        repository.delete(colonyQuery.get());
        return new ColonyDeleteSuccessResponse("Success", "Colony successfully deleted");
    }
    //-----------------------------------------
    //endregion

}

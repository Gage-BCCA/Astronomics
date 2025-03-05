package com.failedalgorithm.astronomics.game.buildings;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingCreationRequest;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingDeleteRequest;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingProduceRequest;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingUpdateRequest;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.failedalgorithm.astronomics.game.buildings.responses.errors.BuildingGenericErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buildings")
public class BuildingController
{

    //================================================================================
    // Injected Services
    //================================================================================
    @Autowired
    BuildingService service;


    //================================================================================
    // Endpoints
    //================================================================================

    //region Getters
    //------------------------------------------
    @GetMapping("/{id}")
    public BuildingResponse getBuildingById(@PathVariable Long id)
    {
        return service.getBuildingById(id);
    }

    @GetMapping
    public Iterable<BuildingDetailsDTO> getAllBuildings()
    {
        return service.getAllBuildings();
    }
    //------------------------------------------
    //endregion

    //region Creators
    //------------------------------------------
    @PostMapping("/build")
    public BuildingResponse createBuilding(@RequestBody BuildingCreationRequest building,
                                           @RequestAttribute("userId") Long userId)
    {
        building.setUserId(userId);
        return service.createBuilding(building);
    }
    //------------------------------------------
    //endregion

    //region Deleters
    //------------------------------------------
    @DeleteMapping("/demolish")
    public BuildingResponse deleteBuilding(@RequestParam Long buildingId,
                                           @RequestAttribute("userId") Long userId)
    {
        BuildingDeleteRequest request = new BuildingDeleteRequest();
        request.setBuildingId(buildingId);
        request.setUserId(userId);
        return service.deleteBuildingById(request);
    }
    //------------------------------------------
    //endregion

    //region Updaters
    //------------------------------------------
    @PutMapping("/update-building")
    public BuildingResponse updateBuilding(@RequestBody BuildingUpdateRequest request,
                                           @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.updateBuildingById(request);
    }
    //------------------------------------------
    //endregion

    //region Building Interactions
    //------------------------------------------
    @PostMapping("/invoke-production")
    public BuildingResponse produceFromBuildingId(@RequestBody BuildingProduceRequest request,
                                                  @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.invokeProduction(request);
    }

    @PostMapping("/activate")
    public BuildingResponse activateBuilding()
    {
        return new BuildingGenericErrorResponse("Not implemented");
    }

    @GetMapping("/activate")
    public BuildingResponse activateBuilding(@RequestParam("buildingId")Long buildingId,
                                             @RequestAttribute("userId") Long userId)
    {
        return new BuildingGenericErrorResponse("Not implemented");
    }

    //------------------------------------------
    //endregion
}

package com.failedalgorithm.astronomics.game.buildings;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDTO;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingCreationRequest;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buildings")
public class BuildingController
{

    @Autowired
    BuildingService service;

    @GetMapping("/{id}")
    public Building getBuildingById(Long id)
    {

        return service.getBuildingById(id).get();
    }

    @GetMapping
    public Iterable<BuildingDTO> getAllBuildings()
    {

        return service.getAllBuildings();
    }


    @PostMapping("/build")
    public BuildingResponse createBuilding(@RequestBody BuildingCreationRequest building, @RequestAttribute("userId") Long userId)
    {

        building.setUserId(userId);
        return service.createBuilding(building);
    }
}

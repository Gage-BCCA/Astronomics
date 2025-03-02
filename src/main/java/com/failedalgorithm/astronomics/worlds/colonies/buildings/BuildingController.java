package com.failedalgorithm.astronomics.worlds.colonies.buildings;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.DTOs.BuildingDTO;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.requests.BuildingCreationRequest;
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
    public Building createBuilding(@RequestBody BuildingCreationRequest building)
    {
        return service.createBuilding(building);
    }
}

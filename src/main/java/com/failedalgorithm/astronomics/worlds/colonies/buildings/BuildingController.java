package com.failedalgorithm.astronomics.worlds.colonies.buildings;

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
    public Iterable<Building> getAllBuildings()
    {
        return service.getAllBuildings();
    }


    @PostMapping("/build")
    public Building createBuilding(@RequestBody Building building)
    {
        return service.createBuilding(building);
    }
}

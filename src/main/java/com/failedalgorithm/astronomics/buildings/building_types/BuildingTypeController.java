package com.failedalgorithm.astronomics.buildings.building_types;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/building-types")
public class BuildingTypeController {

    @Autowired
    BuildingTypeService service;

    @GetMapping
    public Iterable<BuildingType> getAllBuildingTypes() {
        return service.getAllBuildingTypes();
    }

    @PostMapping
    public BuildingType addBuildingType(@RequestBody BuildingType type) {
        return service.addBuildingType(type);
    }

}

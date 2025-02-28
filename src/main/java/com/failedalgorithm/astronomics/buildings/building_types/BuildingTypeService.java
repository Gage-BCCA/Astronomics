package com.failedalgorithm.astronomics.buildings.building_types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingTypeService {

    @Autowired
    BuildingTypeRepository repository;

    public Iterable<BuildingType> getAllBuildingTypes() {
        return repository.findAll();
    }

    public BuildingType addBuildingType(BuildingType type) {
        return repository.save(type);
    }
}

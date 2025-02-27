package com.failedalgorithm.astronomics.buildings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    BuildingRepository repository;

    public Optional<Building> getBuildingById(Long id) {
        return repository.findById(id);
    }
}

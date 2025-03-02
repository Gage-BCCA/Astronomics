package com.failedalgorithm.astronomics.worlds.colonies.buildings;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.DTOs.BuildingDTO;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.requests.BuildingCreationRequest;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.BuildingTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService
{

    @Autowired
    BuildingRepository repository;

    @Autowired
    BuildingTypeFactory factory;

    public Optional<Building> getBuildingById(Long id)
    {
        return repository.findById(id);
    }

    public Iterable<BuildingDTO> getAllBuildings()
    {
        Iterable<Building> buildings = repository.findAll();
        List<BuildingDTO> buildingDTOs = new ArrayList<>();
        for (Building building : buildings)
        {
            buildingDTOs.add(new BuildingDTO(
                    building.getId(),
                    building.getBuildingIdentifier(),
                    building.getBuildingType(),
                    building.isBuilt(),
                    building.isActive(),
                    "None"

            ));
        }

        return buildingDTOs;
    }

    public Building createBuilding(BuildingCreationRequest request)
    {
        Building newBuilding = factory.createBuildingClass(request.getBuildingType());
        newBuilding.setBuildingIdentifier(request.getBuildingIdentifier());
        return repository.save(newBuilding);
    }
}

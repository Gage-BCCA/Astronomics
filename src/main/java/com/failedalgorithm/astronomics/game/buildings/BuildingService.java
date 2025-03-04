package com.failedalgorithm.astronomics.game.buildings;

import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.users.UserRepository;
import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDTO;
import com.failedalgorithm.astronomics.game.buildings.requests.BuildingCreationRequest;
import com.failedalgorithm.astronomics.game.buildings.types.BuildingTypeFactory;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingError;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingSuccessResponse;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.plots.PlotRepository;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.ZoneRepository;
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

    @Autowired
    ZoneRepository zoneRepository;

    @Autowired
    PlotRepository plotRepository;

    @Autowired
    UserRepository userRepository;

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
            buildingDTOs.add(new BuildingDTO(building));
        }

        return buildingDTOs;
    }

    public BuildingResponse createBuilding(BuildingCreationRequest request)
    {
        // Get Zone
        Optional<Zone> zoneQuery = zoneRepository.findByCoordinates(request.getZoneX(), request.getZoneY());
        Zone zone;
        if (zoneQuery.isPresent())
        {
            zone = zoneQuery.get();
        }
        else
        {
            return new BuildingError("Could not find zone.");
        }

        // Get Plot
        Optional<Plot> plotQuery = plotRepository.findByXAndYAndZone(request.getPlotX(), request.getPlotY(), zone);
        Plot plot;
        if (plotQuery.isPresent())
        {
            plot = plotQuery.get();
        }
        else
        {
            return new BuildingError("Could not find plot.");
        }

        // Get User
        Optional<User> userQuery = userRepository.findById(request.getUserId());
        User user;
        if (userQuery.isPresent())
        {
            user = userQuery.get();
        }
        else
        {
            return new BuildingError("Could not find user.");
        }
        Building newBuilding = factory.createBuildingClass(request.getBuildingType());
        newBuilding.setBuildingIdentifier(request.getBuildingIdentifier());
        newBuilding.setZone(zone);
        newBuilding.setPlot(plot);
        newBuilding.setOwner(user);
        repository.save(newBuilding);
        return new BuildingSuccessResponse("Successfully built", new BuildingDTO(newBuilding));
    }

    public Building createInitialCommandCenter(Zone zone, Plot plot, String colonyName, User user)
    {
        Building newBuilding = factory.createBuildingClass("COMMAND_CENTER");
        newBuilding.setBuildingIdentifier(colonyName + "-HQ1");
        newBuilding.setZone(zone);
        newBuilding.setPlot(plot);
        newBuilding.setOwner(user);
        return repository.save(newBuilding);
    }
}

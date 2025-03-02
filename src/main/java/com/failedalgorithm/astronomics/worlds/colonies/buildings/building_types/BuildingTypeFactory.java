package com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.Building;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.types.CommandCenter;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.types.MiningDrill;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.types.SolarFarm;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BuildingTypeFactory
{
    private final Map<String, Class<? extends Building>> buildTypeMap = new HashMap<>();

    @PostConstruct
    public void initialize()
    {
        buildTypeMap.put("MINING_DRILL", MiningDrill.class);
        buildTypeMap.put("SOLAR_FARM", SolarFarm.class);
        buildTypeMap.put("COMMAND_CENTER", CommandCenter.class);
    }

    public Building createBuildingClass(String buildingCode)
    {
        Class<? extends Building> buildingClass = buildTypeMap.get(buildingCode.toUpperCase());

        if (buildingClass == null)
        {
            throw new IllegalArgumentException("Unknown building type: " + buildingCode);
        }

        try
        {
            return buildingClass.getDeclaredConstructor().newInstance(); // Dynamically create the object
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to create animal of type " + buildingCode, e);
        }


    }

}

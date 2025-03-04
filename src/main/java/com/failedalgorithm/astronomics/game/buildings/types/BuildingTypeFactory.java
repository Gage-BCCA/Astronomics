package com.failedalgorithm.astronomics.game.buildings.types;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.types.type_vault.CommandCenter;
import com.failedalgorithm.astronomics.game.buildings.types.type_vault.MiningDrill;
import com.failedalgorithm.astronomics.game.buildings.types.type_vault.SolarFarm;
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
            throw new RuntimeException("Failed to create building of type " + buildingCode, e);
        }


    }

}

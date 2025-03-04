package com.failedalgorithm.astronomics.game.worlds.zones.types;


import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.types.type_vault.Barren;
import com.failedalgorithm.astronomics.game.worlds.zones.types.type_vault.Forrest;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ZoneTypeFactory
{
    private final Map<String, Class<? extends Zone>> zoneTypeMap = new HashMap<>();

    @PostConstruct
    public void initialize()
    {
        zoneTypeMap.put("BARREN", Barren.class);
        zoneTypeMap.put("FORREST", Forrest.class);
    }

    public Zone createZoneClass(String zoneCode)
    {
        Class<? extends Zone> buildingClass = zoneTypeMap.get(zoneCode.toUpperCase());

        if (buildingClass == null)
        {
            throw new IllegalArgumentException("Unknown zone type: " + zoneCode);
        }

        try
        {
            return buildingClass.getDeclaredConstructor().newInstance(); // Dynamically create the object
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to create zone of type " + zoneCode, e);
        }


    }
}

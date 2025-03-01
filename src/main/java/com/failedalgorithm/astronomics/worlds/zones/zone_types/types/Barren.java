package com.failedalgorithm.astronomics.worlds.zones.zone_types.types;

import com.failedalgorithm.astronomics.worlds.zones.zone_types.ZoneType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BARREN")
public class Barren extends ZoneType
{
    private String description = "Void of life and resources. Move elsewhere wartender.";
    private String resourcesPresent = "None";
    private String name = "Barren Wasteland";

    private int hasMetalChance = 15;
    private int hasWoodChance = 0;
    private int hasStoneChance = 90;
    private int isFertileChance = 0;

    @Override
    public int fetchMetalChance()
    {
        return hasMetalChance;
    }

    @Override
    public int fetchFertileChance()
    {
        return isFertileChance;
    }

    @Override
    public int fetchStoneChance()
    {
        return hasStoneChance;
    }

    @Override
    public int fetchWoodChance()
    {
        return hasWoodChance;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getDescription()
    {
        return this.description;
    }
}

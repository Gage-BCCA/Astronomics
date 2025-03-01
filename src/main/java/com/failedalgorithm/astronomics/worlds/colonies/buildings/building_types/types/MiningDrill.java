package com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.types;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.Building;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.BuildingType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MINING_DRILL")
public class MiningDrill extends Building implements BuildingType
{

    private String displayName = "Mining Drill";

    @Override
    public String getBuildingType()
    {
        return "Mining Drill";
    }

    @Override
    public String getDisplayName()
    {
        return this.displayName;
    }
}

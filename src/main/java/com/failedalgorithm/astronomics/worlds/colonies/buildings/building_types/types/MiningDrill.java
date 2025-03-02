package com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.types;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.Building;
import com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.BuildingTypeInterface;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MINING_DRILL")
public class MiningDrill extends Building implements BuildingTypeInterface
{

    @Override
    public String getBuildingType()
    {
        return "Mining Drill";
    }
}

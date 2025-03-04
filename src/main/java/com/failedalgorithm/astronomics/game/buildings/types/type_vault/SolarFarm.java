package com.failedalgorithm.astronomics.game.buildings.types.type_vault;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.types.BuildingTypeInterface;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SOLAR_FARM")
public class SolarFarm extends Building implements BuildingTypeInterface
{
    @Override
    public String getBuildingType()
    {
        return "Solar Farm";
    }
}

package com.failedalgorithm.astronomics.worlds.colonies.buildings.building_types.types;

import com.failedalgorithm.astronomics.worlds.colonies.buildings.Building;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMMAND_CENTER")
public class CommandCenter extends Building
{
    @Override
    public String getBuildingType()
    {
        return "Command Center";
    }
}

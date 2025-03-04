package com.failedalgorithm.astronomics.game.buildings.types.type_vault;

import com.failedalgorithm.astronomics.game.buildings.Building;
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

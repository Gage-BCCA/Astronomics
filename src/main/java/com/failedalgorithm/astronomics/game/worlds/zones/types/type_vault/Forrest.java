package com.failedalgorithm.astronomics.game.worlds.zones.types.type_vault;

import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("FORREST")
public class Forrest extends Zone
{
    //================================================================================
    // Properties
    //================================================================================

    //region Descriptor Values
    //-------------------------------------
    private String description = "Wooded Grove";
    private String name = "Forrest";
    //--------------------------------------
    //endregion

    //region Resource Percent Chances
    //--------------------------------------
    @Transient
    private int hasMetalChance = 10;

    @Transient
    private int hasWoodChance = 90;

    @Transient
    private int hasStoneChance = 5;

    @Transient
    private int isFertileChance = 90;
    //--------------------------------------
    //endregion

    //================================================================================
    // Constructors
    //================================================================================
    public Forrest() {}

    //================================================================================
    // Overridden Methods
    //================================================================================
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
    public String getDescription()
    {
        return description;
    }

    @Override
    public String getName()
    {
        return name;
    }
}

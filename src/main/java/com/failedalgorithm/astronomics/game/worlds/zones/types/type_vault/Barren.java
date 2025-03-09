package com.failedalgorithm.astronomics.game.worlds.zones.types.type_vault;

import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.game.worlds.zones.types.ZoneTypeInterface;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
@DiscriminatorValue("BARREN")
public class Barren extends Zone implements ZoneTypeInterface
{
    //================================================================================
    // Properties
    //================================================================================

    //region Descriptor Values
    //-------------------------------------
    private String description = "Void of life and resources. Move elsewhere wartender.";
    private String name = "Barren Wasteland";
    //--------------------------------------
    //endregion

    //region Resource Percent Chances
    //--------------------------------------
    @Transient
    private int hasMetalChance = 15;

    @Transient
    private int hasWoodChance = 0;

    @Transient
    private int hasStoneChance = 90;

    @Transient
    private int isFertileChance = 0;
    //--------------------------------------
    //endregion

    //================================================================================
    // Constructors
    //================================================================================
    public Barren()
    {
    }

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

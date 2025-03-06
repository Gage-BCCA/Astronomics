package com.failedalgorithm.astronomics.game.buildings.types.type_vault;

import com.failedalgorithm.astronomics.game.buildings.Building;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("INDUSTRIAL_STONECUTTER")
public class IndustrialStonecutter extends Building
{

    //================================================================================
    // Properties
    //================================================================================
    private float craftSpeed;
    private int maxStorage;


    //================================================================================
    // Constructor
    //================================================================================
    public IndustrialStonecutter()
    {
    }


    //================================================================================
    // Production Method
    //================================================================================
    @Override
    public Long produce()
    {
        return null;
    }


    //================================================================================
    // Overridden Methods for Building Config
    //================================================================================
    @Override
    public void setCraftSpeed()
    {
        this.craftSpeed = 1.0f;
    }

    @Override
    public void setMaxStorage()
    {
        this.maxStorage = 1000;
    }

    @Override
    public void setItem()
    {
        super.setItem();
    }


    //================================================================================
    // Overridden Accessors
    //================================================================================
    @Override
    public float getCraftSpeed()
    {
        return this.craftSpeed;
    }

    @Override
    public int getMaxStorage()
    {
        return this.maxStorage;
    }

    @Override
    public String getBuildingType()
    {
        return "Industrial Stonecutter";
    }

}

package com.failedalgorithm.astronomics.game.buildings.types.type_vault;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.types.BuildingTypeInterface;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.springframework.security.core.parameters.P;

@Entity
@DiscriminatorValue("MINING_DRILL")
public class MiningDrill extends Building implements BuildingTypeInterface
{

    //================================================================================
    // Properties
    //================================================================================
    private float craftSpeed;
    private int maxStorage;


    //================================================================================
    // Constructor
    //================================================================================
    public MiningDrill()
    {
    }


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getBuildingType()
    {
        return "Mining Drill";
    }

    @Override
    public Long produce()
    {
        return 100L;
    }

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
}

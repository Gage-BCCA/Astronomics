package com.failedalgorithm.astronomics.game.buildings.types.type_vault;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.types.BuildingTypeInterface;
import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("MINING_DRILL")
public class MiningDrill extends Building implements BuildingTypeInterface
{

    //================================================================================
    // Properties
    //================================================================================
    private float craftSpeed;
    private int maxStorage;

    @ManyToOne
    @JoinColumn(name = "item_produced_id")
    private Item item;


    //================================================================================
    // Constructor
    //================================================================================
    public MiningDrill()
    {
    }


    //================================================================================
    // Production Method
    //================================================================================
    @Override
    public Long produce()
    {

        return 100L;
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
    public void setItem(Item item)
    {
        this.item = item;
    }

    @Override
    public Item getItem()
    {
        return this.item;
    }
}

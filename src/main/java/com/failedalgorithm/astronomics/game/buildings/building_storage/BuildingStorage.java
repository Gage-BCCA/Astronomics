package com.failedalgorithm.astronomics.game.buildings.building_storage;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.*;

@Entity
public class BuildingStorage
{
    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private Long amount;


    //================================================================================
    // Properties
    //================================================================================
    public BuildingStorage()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Building getBuilding()
    {
        return building;
    }

    public void setBuilding(Building building)
    {
        this.building = building;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }
}

package com.failedalgorithm.astronomics.game.buildings.types.produced_items;

import com.failedalgorithm.astronomics.game.items.Item;
import jakarta.persistence.*;

@Entity
public class ProducedItem
{
    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String buildingType;

    @OneToOne
    private Item item;

    //================================================================================
    // Constructors
    //================================================================================
    public ProducedItem()
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

    public String getBuildingType()
    {
        return buildingType;
    }

    public void setBuildingType(String buildingType)
    {
        this.buildingType = buildingType;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }
}

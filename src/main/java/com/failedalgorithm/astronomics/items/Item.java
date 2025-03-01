package com.failedalgorithm.astronomics.items;

import com.failedalgorithm.astronomics.items.item_types.ItemType;
import jakarta.persistence.*;


@Entity
@Table(name = "items")
public class Item
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String description;

    private Integer baseValue;

    private Integer unitSize;

    @OneToOne
    @JoinColumn(name = "item_type")
    private ItemType itemType;

    public String getItemName()
    {
        return this.itemName;
    }

    public Integer getUnitSize()
    {
        return this.unitSize;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setBaseValue(Integer baseValue)
    {
        this.baseValue = baseValue;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }

    public void setUnitSize(Integer unitSize)
    {
        this.unitSize = unitSize;
    }


}

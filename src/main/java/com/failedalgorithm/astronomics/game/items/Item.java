package com.failedalgorithm.astronomics.game.items;

import com.failedalgorithm.astronomics.game.buildings.building_storage.BuildingStorage;
import com.failedalgorithm.astronomics.game.items.types.ItemType;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type",
        discriminatorType = DiscriminatorType.STRING)
public class Item
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private String description;

    @Transient
    private int baseValue;

    @Transient
    private Integer unitSize;

    @OneToMany(mappedBy = "item")
    private Set<BuildingStorage> itemsInStorage;


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

    public void setUnitSize(Integer unitSize)
    {
        this.unitSize = unitSize;
    }

    public String getItemName()
    {
        return "";
    }



}

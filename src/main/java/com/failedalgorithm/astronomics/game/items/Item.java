package com.failedalgorithm.astronomics.game.items;

import jakarta.persistence.*;


@Entity
@Table(name = "items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "itemtype",
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

    public String getItemType()
    {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getBaseValue()
    {
        return baseValue;
    }

    public void setBaseValue(int baseValue)
    {
        this.baseValue = baseValue;
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

    public void setUnitSize(Integer unitSize)
    {
        this.unitSize = unitSize;
    }

    public String getItemName()
    {
        return "";
    }


}

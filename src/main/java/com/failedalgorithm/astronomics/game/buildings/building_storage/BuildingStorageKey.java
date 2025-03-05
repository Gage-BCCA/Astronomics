package com.failedalgorithm.astronomics.game.buildings.building_storage;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

public class BuildingStorageKey implements Serializable
{

    //================================================================================
    // Properties
    //================================================================================
    @Column(name = "building_id")
    private Long studentId;

    @Column(name = "item_id")
    private Long itemId;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingStorageKey()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public Long getStudentId()
    {
        return studentId;
    }

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getItemId()
    {
        return itemId;
    }

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }
}

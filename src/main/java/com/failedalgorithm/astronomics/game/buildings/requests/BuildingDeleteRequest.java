package com.failedalgorithm.astronomics.game.buildings.requests;

public class BuildingDeleteRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private Long userId;
    private Long buildingId;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingDeleteRequest()
    {
    }

    //================================================================================
    // Accessors
    //================================================================================
    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(Long buildingId)
    {
        this.buildingId = buildingId;
    }
}

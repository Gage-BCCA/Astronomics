package com.failedalgorithm.astronomics.game.buildings.requests;

public class BuildingProduceRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private Long buildingId;
    private Long userId;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingProduceRequest()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public Long getBuildingId()
    {
        return buildingId;
    }

    public void setBuildingId(Long buildingId)
    {
        this.buildingId = buildingId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}

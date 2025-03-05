package com.failedalgorithm.astronomics.game.buildings.requests;

public class BuildingUpdateRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private Long userId;
    private Long buildingId;
    private String newIdentifier;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingUpdateRequest()
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

    public String getNewIdentifier()
    {
        return newIdentifier;
    }

    public void setNewIdentifier(String newIdentifier)
    {
        this.newIdentifier = newIdentifier;
    }
}

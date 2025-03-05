package com.failedalgorithm.astronomics.game.buildings.requests;

public class BuildingReadAllRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private Long userId;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingReadAllRequest()
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
}

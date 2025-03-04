package com.failedalgorithm.astronomics.game.colonies.requests;

public class ColonyReadRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private String colonyName;
    private Long userId;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyReadRequest()
    {
    }

    //================================================================================
    // Accessors
    //================================================================================
    public String getColonyName()
    {
        return colonyName;
    }

    public void setColonyName(String colonyName)
    {
        this.colonyName = colonyName;
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

package com.failedalgorithm.astronomics.game.colonies.requests;

public class ColonyUpdateRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private String colonyName;
    private Long UserId;
    private String newName;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyUpdateRequest() {}


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
        return UserId;
    }

    public void setUserId(Long userId)
    {
        UserId = userId;
    }

    public String getNewName()
    {
        return newName;
    }

    public void setNewName(String newName)
    {
        this.newName = newName;
    }
}

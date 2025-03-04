package com.failedalgorithm.astronomics.game.colonies.responses.create;

import com.failedalgorithm.astronomics.game.worlds.zones.Zone;

public class ColonyFoundationFailureResponse implements ColonyFoundationResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String message;
    private String status;
    private Zone zone;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyFoundationFailureResponse () {}

    public ColonyFoundationFailureResponse(String status, String message)
    {
        this.message = message;
        this.status = status;
    }


    //================================================================================
    // Accessors
    //================================================================================
    @Override
    public String getMessage()
    {
        return this.message;
    }

    @Override
    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String getStatus()
    {
        return this.status;
    }

    @Override
    public void setStatus(String status)
    {
        this.status = status;
    }

}

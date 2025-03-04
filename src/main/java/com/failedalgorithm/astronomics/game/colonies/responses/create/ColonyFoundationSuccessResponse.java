package com.failedalgorithm.astronomics.game.colonies.responses.create;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public class ColonyFoundationSuccessResponse implements ColonyFoundationResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String message;
    private String status;
    private Colony colony;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyFoundationSuccessResponse()
    {
    }

    public ColonyFoundationSuccessResponse(String status, String message,
                                           Colony colony)
    {
        this.status = status;
        this.message = message;
        this.colony = colony;

    }


    //================================================================================
    // Overridden Methods
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


    //================================================================================
    // Accessors
    //================================================================================
    public Colony getColony()
    {
        return colony;
    }

    public void setColony(Colony colony)
    {
        this.colony = colony;
    }
}

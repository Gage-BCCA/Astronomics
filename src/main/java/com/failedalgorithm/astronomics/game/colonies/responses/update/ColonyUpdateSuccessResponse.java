package com.failedalgorithm.astronomics.game.colonies.responses.update;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public class ColonyUpdateSuccessResponse implements ColonyUpdateResponse
{
    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;
    private Colony colony;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyUpdateSuccessResponse() {}


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getStatus()
    {
        return this.status;
    }

    @Override
    public String getMessage()
    {
        return this.message;
    }

    @Override
    public Colony getColony()
    {
        return this.colony;
    }


    //================================================================================
    // Accessors
    //================================================================================
    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setColony(Colony colony)
    {
        this.colony = colony;
    }
}

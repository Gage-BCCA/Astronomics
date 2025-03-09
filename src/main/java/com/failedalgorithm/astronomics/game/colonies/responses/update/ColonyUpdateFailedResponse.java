package com.failedalgorithm.astronomics.game.colonies.responses.update;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public class ColonyUpdateFailedResponse implements ColonyUpdateResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyUpdateFailedResponse()
    {
    }

    public ColonyUpdateFailedResponse(String status, String message)
    {
        this.status = status;
        this.message = message;
    }


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
        return null;
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
}

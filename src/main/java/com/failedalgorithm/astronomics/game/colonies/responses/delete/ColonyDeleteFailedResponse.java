package com.failedalgorithm.astronomics.game.colonies.responses.delete;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public class ColonyDeleteFailedResponse implements ColonyDeleteResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyDeleteFailedResponse()
    {
    }

    public ColonyDeleteFailedResponse(String status, String message)
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

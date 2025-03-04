package com.failedalgorithm.astronomics.game.colonies.responses.read;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public class ColonyReadByOwnerResponse implements ColonyReadResponse
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
    public ColonyReadByOwnerResponse()
    {
    }

    public ColonyReadByOwnerResponse(String status, String message, Colony colony)
    {
        this.status = status;
        this.message = message;
        this.colony = colony;
    }


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getStatus()
    {
        return "";
    }

    @Override
    public String getMessage()
    {
        return "";
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

    public void setColony(Colony colony)
    {
        this.colony = colony;
    }
}

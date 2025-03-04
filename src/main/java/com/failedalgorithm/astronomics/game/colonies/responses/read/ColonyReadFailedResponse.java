package com.failedalgorithm.astronomics.game.colonies.responses.read;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public class ColonyReadFailedResponse implements ColonyReadResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyReadFailedResponse()
    {
    }

    public ColonyReadFailedResponse(String status, String message)
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
}

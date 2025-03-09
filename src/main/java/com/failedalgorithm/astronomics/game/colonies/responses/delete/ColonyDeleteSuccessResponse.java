package com.failedalgorithm.astronomics.game.colonies.responses.delete;

import com.failedalgorithm.astronomics.game.colonies.Colony;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ColonyDeleteSuccessResponse implements ColonyDeleteResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;

    @JsonIgnore
    private Colony colony;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyDeleteSuccessResponse()
    {
    }

    public ColonyDeleteSuccessResponse(String status, String message)
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

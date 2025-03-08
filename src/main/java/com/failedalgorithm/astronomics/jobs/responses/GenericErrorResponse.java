package com.failedalgorithm.astronomics.jobs.responses;

public class GenericErrorResponse implements JobResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String message;
    private String status;


    //================================================================================
    // Constructors
    //================================================================================
    public GenericErrorResponse() {}

    public GenericErrorResponse(String status, String message)
    {
        this.message = message;
        this.status = status;
    }


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public String getStatus()
    {
        return status;
    }


    //================================================================================
    // Accessors
    //================================================================================
    public void setMessage(String message)
    {
        this.message = message;
    }


    public void setStatus(String status)
    {
        this.status = status;
    }
}

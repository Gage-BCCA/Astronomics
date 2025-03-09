package com.failedalgorithm.astronomics.users.responses;

public class GenericErrorResponse implements UserResponse
{
    private String status;
    private String message;

    public GenericErrorResponse() {}

    public GenericErrorResponse(String status, String message)
    {
        this.status = status;
        this.message = message;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}

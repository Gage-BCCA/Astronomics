package com.failedalgorithm.astronomics.users.responses;

import org.apache.catalina.User;

public class GenericSuccessResponse implements UserResponse
{
    private String status;
    private String message;

    public GenericSuccessResponse() {}

    public GenericSuccessResponse(String status, String message)
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

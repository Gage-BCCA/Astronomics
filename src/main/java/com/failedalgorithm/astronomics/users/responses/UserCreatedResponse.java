package com.failedalgorithm.astronomics.users.responses;

import java.util.UUID;

public class UserCreatedResponse implements UserResponse
{
    private String status;
    private String message;
    private String apiKey;

    public UserCreatedResponse() {}

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

    public String getApiKey()
    {
        return apiKey;
    }

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }
}

package com.failedalgorithm.astronomics.users.requests;

public class UpdateUserRequest
{
    //================================================================================
    // Properties
    //================================================================================
    private String username;
    private String callsign;
    private Long userId;


    //================================================================================
    // Constructors
    //================================================================================
    public UpdateUserRequest()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getCallsign()
    {
        return callsign;
    }

    public void setCallsign(String callsign)
    {
        this.callsign = callsign;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}

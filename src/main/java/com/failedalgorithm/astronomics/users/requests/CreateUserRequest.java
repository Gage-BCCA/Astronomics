package com.failedalgorithm.astronomics.users.requests;

public class CreateUserRequest
{
    //================================================================================
    // Properties
    //================================================================================
    private String username;
    private String callsign;


    //================================================================================
    // Constructors
    //================================================================================
    public CreateUserRequest () {}


    //================================================================================
    // Accessors
    //================================================================================
    public String getCallsign()
    {
        return callsign;
    }

    public void setCallsign(String callsign)
    {
        this.callsign = callsign;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

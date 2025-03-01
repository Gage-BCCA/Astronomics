package com.failedalgorithm.astronomics.users.DTOs;

public class UserDTO
{

    private String name;
    private String callsign;
    private Long credits;

    public UserDTO(String name, String callsign, Long credits)
    {
        this.name = name;
        this.callsign = callsign;
        this.credits = credits;
    }

    public String getName()
    {
        return this.name;
    }

    public String getCallsign()
    {
        return this.callsign;
    }

    public Long getCredits()
    {
        return this.credits;
    }
}

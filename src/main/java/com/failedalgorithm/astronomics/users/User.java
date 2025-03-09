package com.failedalgorithm.astronomics.users;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String callsign;
    private Long credits;


    public User()
    {
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCallsign()
    {
        return callsign;
    }

    public void setCallsign(String callsign)
    {
        this.callsign = callsign;
    }

    public Long getCredits()
    {
        return credits;
    }

    public void setCredits(Long credits)
    {
        this.credits = credits;
    }
}

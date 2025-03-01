package com.failedalgorithm.astronomics.users;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Users")
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID secret;

    private String name;
    private String callsign;

    private Long credits;


    public void setName(String name)
    {
        this.name = name;
    }

    public void setCallsign(String callsign)
    {
        this.callsign = callsign;
    }

    public void setSecret()
    {
        this.secret = UUID.randomUUID();
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

    public UUID retrieveSecret()
    {
        return this.secret;
    }

    public User()
    {
    }
}

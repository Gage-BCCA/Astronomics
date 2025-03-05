package com.failedalgorithm.astronomics.game.worlds.zones.DTOs;

import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;

public class ZoneSummaryDTO
{
    //================================================================================
    // Properties
    //================================================================================
    private String name;
    private String description;
    private int x;
    private int y;
    private boolean isOccupied;
    private String occupiedType;
    private User owner;

    //================================================================================
    // Constructors
    //================================================================================
    public ZoneSummaryDTO() {}

    public ZoneSummaryDTO(Zone zone)
    {

        this.name = zone.getName();
        this.x = zone.getX();
        this.y = zone.getY();
        this.owner = zone.getOwner();
        this.description = zone.getDescription();
    }

    //================================================================================
    // Accessors
    //================================================================================
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }


    public boolean isOccupied()
    {
        return isOccupied;
    }

    public void setOccupied(boolean occupied)
    {
        isOccupied = occupied;
    }

    public String getOccupiedType()
    {
        return occupiedType;
    }

    public void setOccupiedType(String occupiedType)
    {
        this.occupiedType = occupiedType;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }
}

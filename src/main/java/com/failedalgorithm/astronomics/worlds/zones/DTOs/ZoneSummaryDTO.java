package com.failedalgorithm.astronomics.worlds.zones.DTOs;

import com.failedalgorithm.astronomics.users.User;

public class ZoneSummaryDTO
{
    private String name;
    private String description;
    private int xCoord;
    private int yCoord;
    private String zoneType;
    private boolean isOccupied;
    private String occupiedType;

    private User owner;

    public int getxCoord()
    {
        return xCoord;
    }

    public int getyCoord()
    {
        return yCoord;
    }

    public String getZoneType()
    {
        return zoneType;
    }

    public boolean isOccupied()
    {
        return isOccupied;
    }

    public void setxCoord(int xCoord)
    {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord)
    {
        this.yCoord = yCoord;
    }

    public void setZoneType(String zoneType)
    {
        this.zoneType = zoneType;
    }

    public void setOccupied(boolean occupied)
    {
        isOccupied = occupied;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }

    public String getOccupiedType()
    {
        return occupiedType;
    }

    public void setOccupiedType(String occupiedType)
    {
        this.occupiedType = occupiedType;
    }

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
}

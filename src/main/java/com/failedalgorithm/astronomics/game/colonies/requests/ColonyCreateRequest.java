package com.failedalgorithm.astronomics.game.colonies.requests;

public class ColonyCreateRequest
{

    //================================================================================
    // Properties
    //================================================================================
    private int plotX;
    private int plotY;
    private int zoneX;
    private int zoneY;
    private String colonyName;
    private Long UserId;


    //================================================================================
    // Constructors
    //================================================================================
    public ColonyCreateRequest()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public int getPlotX()
    {
        return plotX;
    }

    public void setPlotX(int plotX)
    {
        this.plotX = plotX;
    }

    public int getPlotY()
    {
        return plotY;
    }

    public void setPlotY(int plotY)
    {
        this.plotY = plotY;
    }

    public int getZoneX()
    {
        return zoneX;
    }

    public void setZoneX(int zoneX)
    {
        this.zoneX = zoneX;
    }

    public int getZoneY()
    {
        return zoneY;
    }

    public void setZoneY(int zoneY)
    {
        this.zoneY = zoneY;
    }

    public String getColonyName()
    {
        return colonyName;
    }

    public void setColonyName(String colonyName)
    {
        this.colonyName = colonyName;
    }

    public Long getUserId()
    {
        return UserId;
    }

    public void setUserId(Long userId)
    {
        UserId = userId;
    }
}

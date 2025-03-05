package com.failedalgorithm.astronomics.game.buildings.requests;

import com.failedalgorithm.astronomics.users.User;

public class BuildingCreationRequest
{

    private String buildingType;
    private String buildingIdentifier;

    private String colonyId;

    private int zoneX;
    private int zoneY;
    private int plotX;
    private int plotY;

    private Long userId;

    public String getBuildingType()
    {
        return buildingType;
    }

    public void setBuildingType(String buildingType)
    {
        this.buildingType = buildingType;
    }

    public String getBuildingIdentifier()
    {
        return buildingIdentifier;
    }

    public void setBuildingIdentifier(String buildingIdentifier)
    {
        this.buildingIdentifier = buildingIdentifier;
    }

    public String getColonyId()
    {
        return colonyId;
    }

    public void setColonyId(String colonyId)
    {
        this.colonyId = colonyId;
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

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}

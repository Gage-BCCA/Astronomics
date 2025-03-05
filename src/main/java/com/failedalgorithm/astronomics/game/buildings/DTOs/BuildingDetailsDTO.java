package com.failedalgorithm.astronomics.game.buildings.DTOs;

import com.failedalgorithm.astronomics.game.buildings.Building;

import java.util.Date;

public class BuildingDetailsDTO
{

    //================================================================================
    // Properties
    //================================================================================
    private final Long id;
    private final String colonyName;
    private final String buildingIdentifier;
    private final String buildingType;
    private boolean isBuilt;
    private boolean isActive;
    private int zoneX;
    private int zoneY;
    private int plotX;
    private int plotY;
    private Date lastProductionTimestamp;
    private Date dateCreated;
    private Date lastModifiedTimestamp;
    private float craftSpeed;
    private int maxStorage;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingDetailsDTO(Building building)
    {
        this.id = building.getId();
        this.buildingIdentifier = building.getBuildingIdentifier();
        this.buildingType = building.getBuildingType();
        this.isBuilt = building.isBuilt();
        this.isActive = building.isActive();
        this.colonyName = building.getColony().getColonyName();
        this.zoneX = building.getZone().getX();
        this.zoneY = building.getZone().getY();
        this.plotX = building.getPlot().getX();
        this.plotY = building.getPlot().getY();
        this.lastProductionTimestamp = building.getLastProductionTimestamp();
        this.dateCreated = building.getDateCreated();
        this.lastModifiedTimestamp = building.getLastModifiedTimestamp();
        this.craftSpeed = building.getCraftSpeed();
        this.maxStorage = building.getMaxStorage();

    }


    //================================================================================
    // Accessors
    //================================================================================
    public Long getId()
    {

        return id;
    }

    public String getColonyName()
    {

        return colonyName;
    }

    public String getBuildingIdentifier()
    {

        return buildingIdentifier;
    }

    public String getBuildingType()
    {

        return buildingType;
    }

    public boolean isBuilt()
    {

        return isBuilt;
    }

    public boolean isActive()
    {

        return isActive;
    }

    public void setBuilt(boolean built)
    {
        isBuilt = built;
    }

    public void setActive(boolean active)
    {
        isActive = active;
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

    public Date getLastProductionTimestamp()
    {
        return lastProductionTimestamp;
    }

    public void setLastProductionTimestamp(Date lastProductionTimestamp)
    {
        this.lastProductionTimestamp = lastProductionTimestamp;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public Date getLastModifiedTimestamp()
    {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Date lastModifiedTimestamp)
    {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public float getCraftSpeed()
    {
        return craftSpeed;
    }

    public void setCraftSpeed(float craftSpeed)
    {
        this.craftSpeed = craftSpeed;
    }

    public int getMaxStorage()
    {
        return maxStorage;
    }

    public void setMaxStorage(int maxStorage)
    {
        this.maxStorage = maxStorage;
    }
}

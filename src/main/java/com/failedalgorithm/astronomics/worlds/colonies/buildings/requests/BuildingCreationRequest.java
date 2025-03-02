package com.failedalgorithm.astronomics.worlds.colonies.buildings.requests;

public class BuildingCreationRequest
{
    private String buildingType;
    private String buildingIdentifier;

    private String colonyId;

    private int zoneX;
    private int zoneY;
    private int plotX;
    private int plotY;

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
}

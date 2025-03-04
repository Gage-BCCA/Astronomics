package com.failedalgorithm.astronomics.game.buildings.DTOs;

import com.failedalgorithm.astronomics.game.buildings.Building;

public class BuildingDTO
{

    private final Long id;
    private final String colony;
    private final String buildingIdentifier;
    private final String buildingType;
    private boolean isBuilt;
    private boolean isActive;

    public BuildingDTO(
            Long id,
            String buildingIdentifier,
            String buildingType,
            boolean isBuilt,
            boolean isActive,
            String colonyName
    )
    {

        this.id = id;
        this.buildingIdentifier = buildingIdentifier;
        this.buildingType = buildingType;
        this.colony = colonyName;
    }

    public BuildingDTO(Building building)
    {
        this.id = building.getId();
        this.buildingIdentifier = building.getBuildingIdentifier();
        this.buildingType = building.getBuildingType();
        this.isBuilt = building.isBuilt();
        this.isActive = building.isActive();
        this.colony = "None";
    }

    public Long getId()
    {

        return id;
    }

    public String getColony()
    {

        return colony;
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
}

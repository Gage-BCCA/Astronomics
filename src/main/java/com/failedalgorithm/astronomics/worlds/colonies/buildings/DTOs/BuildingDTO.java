package com.failedalgorithm.astronomics.worlds.colonies.buildings.DTOs;

import com.failedalgorithm.astronomics.worlds.colonies.Colony;
import jakarta.persistence.*;

public class BuildingDTO
{
    private Long id;
    private String colony;
    private String buildingIdentifier;
    private String buildingType;
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
        this. buildingType = buildingType;
        this.colony = colonyName;
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

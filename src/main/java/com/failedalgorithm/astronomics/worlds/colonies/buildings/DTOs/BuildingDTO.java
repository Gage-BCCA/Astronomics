package com.failedalgorithm.astronomics.worlds.colonies.buildings.DTOs;

import com.failedalgorithm.astronomics.worlds.colonies.Colony;
import jakarta.persistence.*;

public class BuildingDTO
{
    private Long id;

    private Colony colony;

    private String buildingIdentifier;
    private String buildingType;
    private boolean isBuilt;
    private boolean isActive;

    public BuildingDTO(

    )
    {

    }
}

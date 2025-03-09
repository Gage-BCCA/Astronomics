package com.failedalgorithm.astronomics.game.buildings.responses.successes;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;

public class BuildingCreatedResponse implements BuildingResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;
    private BuildingDetailsDTO building;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingCreatedResponse(String status, String message, BuildingDetailsDTO building)
    {
        this.status = status;
        this.message = message;
        this.building = building;
    }

    public BuildingCreatedResponse()
    {
    }


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public BuildingDetailsDTO getBuildingDTO()
    {
        return building;
    }

    @Override
    public String getStatus()
    {
        return this.status;
    }
}

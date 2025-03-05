package com.failedalgorithm.astronomics.game.buildings.responses.successes;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"buildingDTO"})
public class BuildingFoundResponse implements BuildingResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status = "Success";
    private String message = "Building located";
    private BuildingDetailsDTO building;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingFoundResponse(BuildingDetailsDTO dto)
    {
        this.building = dto;
    }


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getStatus()
    {
        return this.status;
    }

    @Override
    public String getMessage()
    {
        return this.message;
    }

    @Override
    public BuildingDetailsDTO getBuildingDTO()
    {
        return null;
    }


    //================================================================================
    // Accessors
    //================================================================================
    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public BuildingDetailsDTO getBuilding()
    {
        return building;
    }

    public void setBuilding(BuildingDetailsDTO building)
    {
        this.building = building;
    }
}

package com.failedalgorithm.astronomics.game.buildings.responses.successes;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"buildingDTO"})
public class BuildingCollectionFoundResponse implements BuildingResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status = "Success";
    private String message = "Buildings located";
    private Iterable<BuildingDetailsDTO> buildings;

    @JsonIgnore
    private BuildingDetailsDTO building;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingCollectionFoundResponse()
    {
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

    public Iterable<BuildingDetailsDTO> getBuildings()
    {
        return buildings;
    }

    public void setBuildings(Iterable<BuildingDetailsDTO> buildings)
    {
        this.buildings = buildings;
    }
}

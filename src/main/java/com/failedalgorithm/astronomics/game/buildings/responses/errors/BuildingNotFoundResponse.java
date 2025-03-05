package com.failedalgorithm.astronomics.game.buildings.responses.errors;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"buildingDTO"})
public class BuildingNotFoundResponse implements BuildingResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status = "Failure";
    private String message = "Building was not found in the records.";


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingNotFoundResponse()
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
}

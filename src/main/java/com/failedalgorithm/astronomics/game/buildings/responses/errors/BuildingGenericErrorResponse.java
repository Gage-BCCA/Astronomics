package com.failedalgorithm.astronomics.game.buildings.responses.errors;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"buildingDTO"})
public class BuildingGenericErrorResponse implements BuildingResponse
{
    private String message;
    private BuildingDetailsDTO building;


    @Override
    public String getMessage() {
        return message;
    }

    public BuildingGenericErrorResponse(String message)
    {
        this.message = message;
    }

    @Override
    public BuildingDetailsDTO getBuildingDTO()
    {
        return new BuildingDetailsDTO(new Building());
    }

    @Override
    public String getStatus()
    {
        return "";
    }
}

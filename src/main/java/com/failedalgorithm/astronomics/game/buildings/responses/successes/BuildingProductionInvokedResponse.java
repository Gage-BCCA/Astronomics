package com.failedalgorithm.astronomics.game.buildings.responses.successes;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;
import com.failedalgorithm.astronomics.game.buildings.responses.BuildingResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"buildingDTO"})
public class BuildingProductionInvokedResponse implements BuildingResponse
{

    //================================================================================
    // Properties
    //================================================================================
    private String status = "Success";
    private String message = "Resources have been produced";
    private Long resourcesProduced;

    private BuildingDetailsDTO building;


    //================================================================================
    // Constructors
    //================================================================================
    public BuildingProductionInvokedResponse(Long resourcesProduced)
    {
        this.resourcesProduced = resourcesProduced;
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
        return building;
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

    public Long getResourcesProduced()
    {
        return resourcesProduced;
    }

    public void setResourcesProduced(Long resourcesProduced)
    {
        this.resourcesProduced = resourcesProduced;
    }
}

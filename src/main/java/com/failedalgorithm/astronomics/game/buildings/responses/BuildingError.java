package com.failedalgorithm.astronomics.game.buildings.responses;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDTO;

public class BuildingError implements BuildingResponse {
    private String message;
    private BuildingDTO building;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BuildingError(String message)
    {
        this.message = message;
    }

    @Override
    public BuildingDTO getBuilding()
    {
        return new BuildingDTO(new Building());
    }

}

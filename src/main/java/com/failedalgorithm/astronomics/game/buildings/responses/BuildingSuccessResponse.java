package com.failedalgorithm.astronomics.game.buildings.responses;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDTO;

public class BuildingSuccessResponse implements BuildingResponse {
    private String message;
    private BuildingDTO building;

    public BuildingSuccessResponse(String message, BuildingDTO building)
    {
        this.message = message;
        this.building = building;
    }

    public BuildingSuccessResponse() {}

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public BuildingDTO getBuilding() {
        return building;
    }
}

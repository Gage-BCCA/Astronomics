package com.failedalgorithm.astronomics.game.buildings.responses;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDetailsDTO;

public interface BuildingResponse {
    public String getStatus();
    public String getMessage();
    public BuildingDetailsDTO getBuildingDTO();
}

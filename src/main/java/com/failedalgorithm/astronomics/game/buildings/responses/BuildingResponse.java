package com.failedalgorithm.astronomics.game.buildings.responses;

import com.failedalgorithm.astronomics.game.buildings.DTOs.BuildingDTO;

public interface BuildingResponse {

    void setMessage(String message);
    String getMessage();

    BuildingDTO getBuilding();
}

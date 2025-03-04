package com.failedalgorithm.astronomics.game.colonies.responses;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public interface ColonyResponse
{
    public String getStatus();
    public String getMessage();
    public Colony getColony();
}

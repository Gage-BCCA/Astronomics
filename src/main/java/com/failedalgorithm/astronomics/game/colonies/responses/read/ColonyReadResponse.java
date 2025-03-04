package com.failedalgorithm.astronomics.game.colonies.responses.read;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public interface ColonyReadResponse
{
    public String getStatus();
    public String getMessage();
    public Colony getColony();
}

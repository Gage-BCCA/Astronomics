package com.failedalgorithm.astronomics.game.colonies.responses.delete;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public interface ColonyDeleteResponse
{
    public String getStatus();

    public String getMessage();

    public Colony getColony();
}

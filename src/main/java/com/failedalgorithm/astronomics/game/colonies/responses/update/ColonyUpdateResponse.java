package com.failedalgorithm.astronomics.game.colonies.responses.update;

import com.failedalgorithm.astronomics.game.colonies.Colony;

public interface ColonyUpdateResponse
{
    public String getStatus();
    public String getMessage();
    public Colony getColony();
}

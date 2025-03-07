package com.failedalgorithm.astronomics.jobs.types.type_vault;

import com.failedalgorithm.astronomics.game.items.Item;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.jobs.Job;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@DiscriminatorValue("MOVE_RESOURCES")
public class MoveResources extends Job
{


    //================================================================================
    // Properties
    //================================================================================
    @Transient
    private HashMap<String, Integer> resourcesBeingMoved;

    private int jobTimeInSeconds;

    //================================================================================
    // Constructors
    //================================================================================
    public MoveResources() {}

    public MoveResources(HashMap<String, Integer> resourcesBeingMoved,
                         Plot origin,
                         Plot target)
    {
        this.resourcesBeingMoved = resourcesBeingMoved;

        int counter = 0;
        for (Integer value : resourcesBeingMoved.values())
        {
            counter += value / 2;
        }

        this.jobTimeInSeconds = counter;
    }

    //================================================================================
    // Overridden methods
    //================================================================================
    @Override
    public int getJobTimeInSeconds()
    {
        return jobTimeInSeconds;
    }

    @Override
    public void setJobTimeInSeconds(int jobTimeInSeconds)
    {
        this.jobTimeInSeconds = jobTimeInSeconds;
    }


    //================================================================================
    // Accessors
    //================================================================================
    public HashMap<String, Integer> getResourcesBeingMoved()
    {
        return resourcesBeingMoved;
    }

    public void setResourcesBeingMoved(HashMap<String, Integer> resourcesBeingMoved)
    {
        this.resourcesBeingMoved = resourcesBeingMoved;
    }
}

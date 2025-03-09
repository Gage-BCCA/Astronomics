package com.failedalgorithm.astronomics.game.jobs.types.type_vault;

import com.failedalgorithm.astronomics.game.jobs.Job;
import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobSuccessResponse;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.Map;

@Entity
@DiscriminatorValue("MOVE_RESOURCES")
public class MoveResources extends Job
{


    //================================================================================
    // Properties
    //================================================================================
    @Transient
    private Map<String, Integer> resources;

    private int jobTimeInSeconds;

    //================================================================================
    // Constructors
    //================================================================================
    public MoveResources()
    {
    }


    //================================================================================
    // Job Execution
    //================================================================================
    @Override
    public JobResultResponse executeJob()
    {
        JobSuccessResponse response = new JobSuccessResponse();
        response.setMessage("Move Resources executed.");
        return response;
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
    public void setResources(Map<String, Integer> resources)
    {
        this.resources = resources;
    }

    public Map<String, Integer> getResources()
    {
        return resources;
    }
}

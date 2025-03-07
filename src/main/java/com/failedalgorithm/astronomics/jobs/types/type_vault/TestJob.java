package com.failedalgorithm.astronomics.jobs.types.type_vault;

import com.failedalgorithm.astronomics.jobs.Job;
import com.failedalgorithm.astronomics.jobs.types.JobType;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobSuccessResponse;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("TEST_JOB")
public class TestJob extends Job
{
    //================================================================================
    // Properties
    //================================================================================
    private int jobTimeInSeconds = 10;


    //================================================================================
    // Constructor
    //================================================================================
    public TestJob() {}

    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public JobResultResponse executeJob()
    {
        JobResultResponse response = new JobSuccessResponse();
        response.setMessage("Test job executed.");
        return response;
    }

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
}

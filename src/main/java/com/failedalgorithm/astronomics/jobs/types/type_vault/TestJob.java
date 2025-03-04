package com.failedalgorithm.astronomics.jobs.types.type_vault;

import com.failedalgorithm.astronomics.jobs.types.JobType;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobSuccessResponse;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("TEST_JOB")
public class TestJob extends JobType
{

    @Override
    public JobResultResponse execute()
    {
        JobResultResponse response = new JobSuccessResponse();
        response.setMessage("Test job executed.");
        return response;
    }
}

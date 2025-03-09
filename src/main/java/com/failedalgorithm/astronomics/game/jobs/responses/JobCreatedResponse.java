package com.failedalgorithm.astronomics.game.jobs.responses;

import com.failedalgorithm.astronomics.game.jobs.Job;

public class JobCreatedResponse implements JobResponse
{
    private String message;
    private String status;
    private Long jobId;

    public JobCreatedResponse(Job job)
    {
        this.jobId = job.getId();
    }

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    @Override
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Long getJobId()
    {
        return jobId;
    }

    public void setJobId(Long jobId)
    {
        this.jobId = jobId;
    }

}

package com.failedalgorithm.astronomics.game.jobs.job_status_responses;

public class JobSuccessResponse implements JobResultResponse
{
    private String message;

    public JobSuccessResponse()
    {
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return this.message;
    }
}

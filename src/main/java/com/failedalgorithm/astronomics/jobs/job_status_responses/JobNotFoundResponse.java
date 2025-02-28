package com.failedalgorithm.astronomics.jobs.job_status_responses;

public class JobNotFoundResponse implements JobResultResponse {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}

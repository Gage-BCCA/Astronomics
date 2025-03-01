package com.failedalgorithm.astronomics.jobs;

import com.failedalgorithm.astronomics.jobs.job_status_responses.JobNotFoundResponse;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobService
{

    @Autowired
    JobRepository repository;

    public Job createJob(Job job)
    {
        return repository.save(job);
    }

    public JobResultResponse executeJob(Long id)
    {
        Optional<Job> targetJob = repository.findById(id);
        if (targetJob.isPresent())
        {
            return targetJob.get().executeJob();
        }
        else
        {
            JobNotFoundResponse response = new JobNotFoundResponse();
            response.setMessage("Error executing job.");
            return response;
        }
    }
}

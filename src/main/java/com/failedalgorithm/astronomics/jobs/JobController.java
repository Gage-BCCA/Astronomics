package com.failedalgorithm.astronomics.jobs;

import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController
{

    @Autowired
    JobService service;

    @PostMapping("/create")
    public Job createJob(@RequestBody Job job)
    {
        return service.createJob(job);
    }

    @GetMapping("/execute/{id}")
    public JobResultResponse executeJob(@PathVariable Long id)
    {
        return service.executeJob(id);
    }
}

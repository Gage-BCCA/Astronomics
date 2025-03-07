package com.failedalgorithm.astronomics.jobs;

import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.jobs.requests.JobCreationRequest;
import com.failedalgorithm.astronomics.jobs.requests.MoveResourcesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController
{

    @Autowired
    JobService service;

    @PostMapping("/create")
    public Job createJob(@RequestBody JobCreationRequest request)
    {
        return service.createJob(request);
    }

    @GetMapping("/execute/{id}")
    public JobResultResponse executeJob(@PathVariable Long id)
    {
        return service.executeJob(id);
    }
}

package com.failedalgorithm.astronomics.game.jobs;

import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.game.jobs.requests.JobCreationRequest;
import com.failedalgorithm.astronomics.game.jobs.responses.JobResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController
{

    @Autowired
    JobService service;

    @PostMapping("/create")
    public JobResponse createJob(@RequestBody JobCreationRequest request,
                                 @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.createJob(request);
    }

    @GetMapping("/execute/{id}")
    public JobResultResponse executeJob(@PathVariable Long id)
    {
        return service.executeJob(id);
    }
}

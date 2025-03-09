package com.failedalgorithm.astronomics.game.jobs;

import com.failedalgorithm.astronomics.game.jobs.job_queue.JobQueue;
import com.failedalgorithm.astronomics.game.jobs.job_queue.JobQueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class JobScannerTask
{

    @Autowired
    JobQueueRepository repository;

    private static final Logger log = LoggerFactory.getLogger(JobScannerTask.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Iterable<JobQueue> jobs = repository.findAll();
        int counter = 0;
        for (JobQueue job : jobs)
        {
            counter += 1;
        }
        log.info("There are {} jobs", counter);
    }

    //================================================================================
    // Properties
    //================================================================================

    //================================================================================
    // Constructors
    //================================================================================

    //================================================================================
    // Accessors
    //================================================================================
}

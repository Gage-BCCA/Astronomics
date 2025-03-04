package com.failedalgorithm.astronomics.jobs;

import com.failedalgorithm.astronomics.jobs.types.JobType;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.users.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Job
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private JobType jobType;

    private String status;
    private String targetType;
    private String targetId;
    private int targetX;
    private int targetY;
    private int jobOriginX;
    private int jobOriginY;

    private Date jobCreationTime;
    private Date jobCompletionTime;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public JobResultResponse executeJob()
    {
        return this.jobType.execute();
    }
}

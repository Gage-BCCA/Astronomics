package com.failedalgorithm.astronomics.game.jobs.types;


import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobSuccessResponse;
import jakarta.persistence.*;

@Entity
@Table(name = "job_types")
public class JobType
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public JobResultResponse execute()
    {
        return new JobSuccessResponse();
    }
}

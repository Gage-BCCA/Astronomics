package com.failedalgorithm.astronomics.jobs.types;


import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobSuccessResponse;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "job_type",
        discriminatorType = DiscriminatorType.STRING)
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

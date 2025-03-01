package com.failedalgorithm.astronomics.jobs.job_queue;

import com.failedalgorithm.astronomics.jobs.Job;
import jakarta.persistence.*;

@Entity
public class JobQueue
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "job_id")
    private Job job;

}

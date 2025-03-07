package com.failedalgorithm.astronomics.jobs;

import com.failedalgorithm.astronomics.jobs.types.JobType;
import com.failedalgorithm.astronomics.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.users.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "job_type",
        discriminatorType = DiscriminatorType.STRING)
public class Job
{

    //================================================================================
    // Properties
    //================================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private String targetType;
    private String targetId;
    private int targetZoneX;
    private int targetZoneY;
    private int targetPlotX;
    private int targetPlotY;
    private int jobOriginZoneX;
    private int jobOriginZoneY;
    private int jobOriginPlotX;
    private int jobOriginPlotY;

    @Temporal(TemporalType.TIMESTAMP)
    private Date jobCreationTime;

    private Date jobCompletionTime;

    @Transient
    private int jobTimeInSeconds;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


    //================================================================================
    // Constructor
    //================================================================================
    public Job()
    {
    }


    //================================================================================
    // Methods to be Overridden
    //================================================================================
    public JobResultResponse executeJob()
    {
        return null;
    }

    public int getJobTimeInSeconds()
    {
        return jobTimeInSeconds;
    }

    public void setJobTimeInSeconds(int jobTimeInSeconds)
    {
        this.jobTimeInSeconds = jobTimeInSeconds;
    }

    //================================================================================
    // Accessors
    //================================================================================

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getTargetType()
    {
        return targetType;
    }

    public void setTargetType(String targetType)
    {
        this.targetType = targetType;
    }

    public String getTargetId()
    {
        return targetId;
    }

    public void setTargetId(String targetId)
    {
        this.targetId = targetId;
    }

    public int getTargetZoneX()
    {
        return targetZoneX;
    }

    public void setTargetZoneX(int targetZoneX)
    {
        this.targetZoneX = targetZoneX;
    }

    public int getTargetZoneY()
    {
        return targetZoneY;
    }

    public void setTargetZoneY(int targetZoneY)
    {
        this.targetZoneY = targetZoneY;
    }

    public int getTargetPlotX()
    {
        return targetPlotX;
    }

    public void setTargetPlotX(int targetPlotX)
    {
        this.targetPlotX = targetPlotX;
    }

    public int getTargetPlotY()
    {
        return targetPlotY;
    }

    public void setTargetPlotY(int targetPlotY)
    {
        this.targetPlotY = targetPlotY;
    }

    public int getJobOriginZoneX()
    {
        return jobOriginZoneX;
    }

    public void setJobOriginZoneX(int jobOriginZoneX)
    {
        this.jobOriginZoneX = jobOriginZoneX;
    }

    public int getJobOriginZoneY()
    {
        return jobOriginZoneY;
    }

    public void setJobOriginZoneY(int jobOriginZoneY)
    {
        this.jobOriginZoneY = jobOriginZoneY;
    }

    public int getJobOriginPlotX()
    {
        return jobOriginPlotX;
    }

    public void setJobOriginPlotX(int jobOriginPlotX)
    {
        this.jobOriginPlotX = jobOriginPlotX;
    }

    public int getJobOriginPlotY()
    {
        return jobOriginPlotY;
    }

    public void setJobOriginPlotY(int jobOriginPlotY)
    {
        this.jobOriginPlotY = jobOriginPlotY;
    }

    public Date getJobCreationTime()
    {
        return jobCreationTime;
    }

    public void setJobCreationTime(Date jobCreationTime)
    {
        this.jobCreationTime = jobCreationTime;
    }

    public Date getJobCompletionTime()
    {
        return jobCompletionTime;
    }

    public void setJobCompletionTime(Date jobCompletionTime)
    {
        this.jobCompletionTime = jobCompletionTime;
    }

    public User getOwner()
    {
        return owner;
    }

    public void setOwner(User owner)
    {
        this.owner = owner;
    }
}

package com.failedalgorithm.astronomics.game.jobs;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.jobs.job_status_responses.JobResultResponse;
import com.failedalgorithm.astronomics.game.worlds.plots.Plot;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import com.failedalgorithm.astronomics.users.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "jobs")
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

    @ManyToOne
    private Zone targetZone;

    @ManyToOne
    private Plot targetPlot;

    @ManyToOne
    private Zone originZone;

    @ManyToOne
    private Plot originPlot;

    @ManyToOne
    private Building originBuilding;

    @ManyToOne
    private Building targetBuilding;

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

    public Zone getTargetZone()
    {
        return targetZone;
    }

    public void setTargetZone(Zone targetZone)
    {
        this.targetZone = targetZone;
    }

    public Plot getTargetPlot()
    {
        return targetPlot;
    }

    public void setTargetPlot(Plot targetPlot)
    {
        this.targetPlot = targetPlot;
    }

    public Zone getOriginZone()
    {
        return originZone;
    }

    public void setOriginZone(Zone originZone)
    {
        this.originZone = originZone;
    }

    public Plot getOriginPlot()
    {
        return originPlot;
    }

    public void setOriginPlot(Plot originPlot)
    {
        this.originPlot = originPlot;
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

    public Building getTargetBuilding()
    {
        return targetBuilding;
    }

    public void setTargetBuilding(Building targetBuilding)
    {
        this.targetBuilding = targetBuilding;
    }

    public Building getOriginBuilding()
    {
        return originBuilding;
    }

    public void setOriginBuilding(Building originBuilding)
    {
        this.originBuilding = originBuilding;
    }
}

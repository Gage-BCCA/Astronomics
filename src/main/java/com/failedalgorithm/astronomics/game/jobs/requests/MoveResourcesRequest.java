package com.failedalgorithm.astronomics.game.jobs.requests;

import java.util.HashMap;


public class MoveResourcesRequest extends JobCreationRequest
{
    //================================================================================
    // Properties
    //================================================================================
    private String jobType;
    private HashMap<String, Integer> resourcesBeingMoved;
    private int targetZoneX;
    private int targetZoneY;
    private int targetPlotX;
    private int targetPlotY;
    private int jobOriginZoneX;
    private int jobOriginZoneY;
    private int jobOriginPlotX;
    private int jobOriginPlotY;
    private int jobTimeInSeconds;

    //================================================================================
    // Constructors
    //================================================================================
    public MoveResourcesRequest()
    {
    }


    //================================================================================
    // Overridden Methods
    //================================================================================
    @Override
    public String getJobType()
    {
        return this.jobType;
    }

    //================================================================================
    // Accessors
    //================================================================================
    public HashMap<String, Integer> getResourcesBeingMoved()
    {
        return resourcesBeingMoved;
    }

    public void setResourcesBeingMoved(HashMap<String, Integer> resourcesBeingMoved)
    {
        this.resourcesBeingMoved = resourcesBeingMoved;
    }

    public void setJobType(String jobType)
    {
        this.jobType = jobType;
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

    public int getJobTimeInSeconds()
    {
        return jobTimeInSeconds;
    }

    public void setJobTimeInSeconds(int jobTimeInSeconds)
    {
        this.jobTimeInSeconds = jobTimeInSeconds;
    }
}

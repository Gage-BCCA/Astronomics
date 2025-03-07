package com.failedalgorithm.astronomics.jobs.types;

import com.failedalgorithm.astronomics.jobs.Job;
import com.failedalgorithm.astronomics.jobs.types.type_vault.MoveResources;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobFactory
{
    private final Map<String, Class<? extends Job>> jobTypeMap = new HashMap<>();

    @PostConstruct
    public void initialize()
    {
//        buildTypeMap.put("MINING_DRILL", MiningDrill.class);
//        buildTypeMap.put("SOLAR_FARM", SolarFarm.class);
//        buildTypeMap.put("COMMAND_CENTER", CommandCenter.class);
          jobTypeMap.put("MOVE_RESOURCES", MoveResources.class);
    }

    public Job createJobClass(String jobCode)
    {
        Class<? extends Job> buildingClass = jobTypeMap.get(jobCode.toUpperCase());

        if (buildingClass == null)
        {
            throw new IllegalArgumentException("Unknown building type: " + jobCode);
        }

        try
        {
            return buildingClass.getDeclaredConstructor().newInstance(); // Dynamically create the object
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to create building of type " + jobCode, e);
        }


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

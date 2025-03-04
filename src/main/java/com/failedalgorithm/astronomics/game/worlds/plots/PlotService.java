package com.failedalgorithm.astronomics.game.worlds.plots;

import com.failedalgorithm.astronomics.game.buildings.Building;
import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlotService
{
    //================================================================================
    // Injected Properties
    //================================================================================
    @Autowired
    PlotRepository repository;


    //================================================================================
    // Services
    //================================================================================
    public Iterable<Plot> getAllPlots()
    {
        return repository.findAll();
    }

    public Plot getPlotObjectByCoordinates(int x, int y, Zone zone)
    {
        Optional<Plot> plotQuery = repository.findByXAndYAndZone(x, y, zone);
        Plot plot;
        if (plotQuery.isPresent())
        {
            return plotQuery.get();
        }
        return null;
    }

    public Plot updatePlotWithBuilding(Building building, Plot targetPlot)
    {
        targetPlot.setBuilding(building);
        targetPlot.setOccupied(true);
        return repository.save(targetPlot);
    }
}

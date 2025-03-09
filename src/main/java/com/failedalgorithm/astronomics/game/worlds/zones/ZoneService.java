package com.failedalgorithm.astronomics.game.worlds.zones;

import com.failedalgorithm.astronomics.game.worlds.zones.DTOs.ZoneSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneService
{

    //================================================================================
    // Injected Properties
    //================================================================================
    @Autowired
    ZoneRepository repository;


    //================================================================================
    // Services
    //================================================================================
    public Iterable<ZoneSummaryDTO> getAllZoneSummaries()
    {

        Iterable<Zone> zones = repository.findAll();
        List<ZoneSummaryDTO> zoneSummaries = new ArrayList<>();
        for (Zone zone : zones)
        {
            ZoneSummaryDTO summary = new ZoneSummaryDTO(zone);
            zoneSummaries.add(summary);
        }

        return zoneSummaries;
    }

    public ZoneSummaryDTO getZoneSummaryByCoordinates(int x, int y)
    {
        Optional<Zone> zoneQuery = repository.findByCoordinates(x, y);
        if (zoneQuery.isPresent())
        {
            return new ZoneSummaryDTO(zoneQuery.get());
        }
        return new ZoneSummaryDTO();

    }

    public Zone getZoneObjectByCoordinates(int x, int y)
    {
        Optional<Zone> zoneQuery = repository.findByCoordinates(x, y);
        if (zoneQuery.isPresent())
        {
            return zoneQuery.get();
        }
        return null;
    }


}

package com.failedalgorithm.astronomics.worlds.zones;

import com.failedalgorithm.astronomics.worlds.zones.DTOs.ZoneSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZoneService
{

    @Autowired
    ZoneRepository repository;

    public Iterable<ZoneSummaryDTO> getAllZones()
    {

        Iterable<Zone> zones = repository.findAll();
        List<ZoneSummaryDTO> zoneSummaries = new ArrayList<>();
        for (Zone zone : zones)
        {
            ZoneSummaryDTO summary = new ZoneSummaryDTO();

            summary.setOccupied(zone.isOccupied());
            summary.setZoneType(zone.getZoneType().getName());
            summary.setxCoord(zone.getxCoord());
            summary.setyCoord(zone.getyCoord());
            summary.setOccupiedType(zone.getOccupiedType());
            summary.setOwner(zone.getOwner());
            summary.setName(zone.getName());
            summary.setDescription(zone.getZoneTypeDescription());

            zoneSummaries.add(summary);
        }

        return zoneSummaries;
    }

//    public Zone getByCoordinates(Integer x, Integer y) {
//        Optional<Zone> zone = repository.findByCoordinates(x, y);
//        if (zone.isPresent()) {
//            return zone.get();
//        }
//        return new Zone();
//    }
}

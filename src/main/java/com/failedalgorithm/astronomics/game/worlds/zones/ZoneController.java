package com.failedalgorithm.astronomics.game.worlds.zones;

import com.failedalgorithm.astronomics.game.worlds.zones.DTOs.ZoneSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zones")
public class ZoneController
{

    @Autowired
    ZoneService service;

    @GetMapping
    public Iterable<ZoneSummaryDTO> getAllZones()
    {
        return service.getAllZoneSummaries();
    }

    @GetMapping("/scan")
    public ZoneSummaryDTO scanZone(@RequestParam Integer x, @RequestParam Integer y)
    {
        return service.getZoneSummaryByCoordinates(x, y);
    }


}

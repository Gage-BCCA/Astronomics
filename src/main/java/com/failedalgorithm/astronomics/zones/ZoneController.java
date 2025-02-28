package com.failedalgorithm.astronomics.zones;

import com.failedalgorithm.astronomics.zones.DTOs.ZoneDetailsDTO;
import com.failedalgorithm.astronomics.zones.responses.ScanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zones")
public class ZoneController {

    @Autowired
    ZoneService service;

    @GetMapping
    public Iterable<Zone> getAllZones() {
        return service.getAllZones();
    }

}

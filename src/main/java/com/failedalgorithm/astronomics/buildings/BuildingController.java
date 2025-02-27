package com.failedalgorithm.astronomics.buildings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    BuildingService service;

    @GetMapping("/{id}")
    public Building getBuildingById(Long id) {
        return service.getBuildingById(id).get();
    }
}

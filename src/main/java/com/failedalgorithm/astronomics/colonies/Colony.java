package com.failedalgorithm.astronomics.colonies;

import com.failedalgorithm.astronomics.buildings.Building;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Colony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Building> buildings;

}

package com.failedalgorithm.astronomics.colonies;

import com.failedalgorithm.astronomics.buildings.Building;
import com.failedalgorithm.astronomics.users.User;
import com.failedalgorithm.astronomics.zones.Zone;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "colonies")
public class Colony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Building> buildings;

    @OneToOne
    @JoinColumn(name = "parent_zone_id")
    private Zone zone;

    @Column(name = "colony_name")
    private String colonyName;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private int defenseValue;

}

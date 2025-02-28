package com.failedalgorithm.astronomics.buildings;


import com.failedalgorithm.astronomics.buildings.building_types.BuildingType;
import com.failedalgorithm.astronomics.worlds.plots.Plot;
import jakarta.persistence.*;
import com.failedalgorithm.astronomics.colonies.Colony;

@Entity
@Table(name = "buildings")

public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colony_id")
    private Colony colony;

    @OneToOne(mappedBy = "building")
    private Plot plot;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private BuildingType type;

    @Column(name = "building_identifier")
    private String buildingIdentifier;

    @Column(name = "is_built")
    private boolean isBuilt;

    @Column(name = "is_active")
    private boolean isActive;

}

package com.failedalgorithm.astronomics.plots;

import com.failedalgorithm.astronomics.buildings.Building;
import com.failedalgorithm.astronomics.zones.Zone;
import jakarta.persistence.*;

@Entity
@Table(name = "plots")
public class Plot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    private Building building;

    @ManyToOne
    @JoinColumn(name = "parent_zone_id")
    private Zone zone;

    private Integer x_coord;
    private Integer y_coord;
}

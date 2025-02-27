package com.failedalgorithm.astronomics.plots;

import com.failedalgorithm.astronomics.buildings.Building;
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

    private Integer x_coord;
    private Integer y_coord;
}

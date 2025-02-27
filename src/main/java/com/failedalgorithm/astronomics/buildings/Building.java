package com.failedalgorithm.astronomics.buildings;


import com.failedalgorithm.astronomics.items.Item;
import com.failedalgorithm.astronomics.plots.Plot;
import jakarta.persistence.*;
import com.failedalgorithm.astronomics.colonies.Colony;

@Entity
@Table(name = "buildings")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type",
        discriminatorType = DiscriminatorType.STRING)
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

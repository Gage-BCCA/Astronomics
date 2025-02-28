package com.failedalgorithm.astronomics.zones.zone_types;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_name",
        discriminatorType = DiscriminatorType.STRING)
public class ZoneType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

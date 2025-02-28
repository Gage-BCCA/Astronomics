package com.failedalgorithm.astronomics.zones;

import com.failedalgorithm.astronomics.worlds.World;
import jakarta.persistence.*;

@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_world_id")
    private World world;

    private int x_coord;
    private int y_coord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_type")
    private Zone zoneType;


}

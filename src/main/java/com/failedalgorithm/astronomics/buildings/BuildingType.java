package com.failedalgorithm.astronomics.buildings;

import com.failedalgorithm.astronomics.items.Item;
import jakarta.persistence.*;

@Entity
public class BuildingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemProduced;

    private Long maxStorage;
    private Long currentStorage;

    private Long foodConsumptionAmt;
    private Long powerConsumptionAmt;


}

package com.failedalgorithm.astronomics.buildings.building_types;

import com.failedalgorithm.astronomics.items.Item;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_name",
        discriminatorType = DiscriminatorType.STRING)
public class BuildingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item itemProduced;

    private Long maxStorage;
    private Long currentStorage;

    private Long foodConsumptionAmt;
    private Long powerConsumptionAmt;

    private Integer craftSpeed;

}

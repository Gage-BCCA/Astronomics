package com.failedalgorithm.astronomics.game.items.types;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type",
        discriminatorType = DiscriminatorType.STRING)
public class ItemType
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}

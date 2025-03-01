package com.failedalgorithm.astronomics.items.item_types.types.advanced_types;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("REFINED_METAL")
public class RefinedMetal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

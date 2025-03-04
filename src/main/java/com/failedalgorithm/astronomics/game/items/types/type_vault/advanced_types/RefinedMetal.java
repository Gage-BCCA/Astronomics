package com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("REFINED_METAL")
public class RefinedMetal
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

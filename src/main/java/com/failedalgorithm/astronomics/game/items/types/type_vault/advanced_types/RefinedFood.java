package com.failedalgorithm.astronomics.game.items.types.type_vault.advanced_types;

import com.failedalgorithm.astronomics.game.items.types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("REFINED_FOOD")
public class RefinedFood extends ItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

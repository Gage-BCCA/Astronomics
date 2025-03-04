package com.failedalgorithm.astronomics.game.items.types.type_vault;

import com.failedalgorithm.astronomics.game.items.types.ItemType;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("RAW_WOOD")
public class RawWood extends ItemType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

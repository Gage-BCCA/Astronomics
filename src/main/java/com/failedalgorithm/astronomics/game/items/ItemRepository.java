package com.failedalgorithm.astronomics.game.items;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long>
{
    Optional<Item> findByItemType(@Param("itemType") String itemType);
}

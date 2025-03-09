package com.failedalgorithm.astronomics.game.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long>
{
    @Query("SELECT i FROM Item i WHERE type(i) = :itemtype")
    Optional<Item> findByItemType(@Param("itemtype") String itemType);
}

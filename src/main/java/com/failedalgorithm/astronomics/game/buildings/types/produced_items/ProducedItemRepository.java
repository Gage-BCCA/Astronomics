package com.failedalgorithm.astronomics.game.buildings.types.produced_items;

import com.failedalgorithm.astronomics.game.items.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProducedItemRepository extends CrudRepository<ProducedItem, Long>
{
    Optional<ProducedItem> findByItem(Item item);

    Optional<ProducedItem> findByBuildingType(String type);
}

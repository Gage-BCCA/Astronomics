package com.failedalgorithm.astronomics.game.buildings.building_storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingStorageRepository extends CrudRepository<BuildingStorage, Long>
{

}

package com.failedalgorithm.astronomics.game.buildings.building_storage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingStorageRepository extends CrudRepository<BuildingStorage, Long>
{
    Iterable<BuildingStorage> findByBuildingId(@Param("buildingId") Long id);
}

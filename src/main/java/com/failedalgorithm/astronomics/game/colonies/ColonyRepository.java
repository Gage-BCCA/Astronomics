package com.failedalgorithm.astronomics.game.colonies;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColonyRepository extends CrudRepository<Colony, Long>
{
    Optional<Colony> findByName(@Param("name") String name);
}

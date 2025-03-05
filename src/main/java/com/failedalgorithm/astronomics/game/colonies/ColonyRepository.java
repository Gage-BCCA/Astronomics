package com.failedalgorithm.astronomics.game.colonies;


import com.failedalgorithm.astronomics.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColonyRepository extends CrudRepository<Colony, Long>
{
    Optional<Colony> findByColonyName(@Param("colonyName") String name);
    Optional<Colony> findByOwner(@Param("owner") User user);
}

package com.failedalgorithm.astronomics.worlds.zones;

import com.failedalgorithm.astronomics.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

//    @Query(value = "SELECT z FROM Zone z WHERE z.xCoord= :x AND z.yCoord = :y")
//    Optional<Zone> findByCoordinates(@Param("x") Integer x, @Param("y") Integer y);
}

package com.failedalgorithm.astronomics.game.worlds.plots;

import com.failedalgorithm.astronomics.game.worlds.zones.Zone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlotRepository extends CrudRepository<Plot, Long>
{
    Optional<Plot> findByXAndYAndZone(@Param("x") Integer x, @Param("y") Integer y, @Param("zone") Zone zone);
}

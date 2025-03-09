package com.failedalgorithm.astronomics.game.jobs.attached_resources;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachedResourcesRepository extends CrudRepository<AttachedResources, Long>
{
}

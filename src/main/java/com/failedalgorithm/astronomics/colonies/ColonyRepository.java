package com.failedalgorithm.astronomics.colonies;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColonyRepository extends CrudRepository<Colony, Long> {}

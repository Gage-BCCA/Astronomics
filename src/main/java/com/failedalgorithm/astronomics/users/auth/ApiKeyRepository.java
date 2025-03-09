package com.failedalgorithm.astronomics.users.auth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiKeyRepository extends CrudRepository<ApiKey, Long>
{
    Optional<ApiKey> findByKey(String key);
    Optional<ApiKey>findByUserId(Long id);
}

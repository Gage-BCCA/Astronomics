package com.failedalgorithm.astronomics.worlds;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.failedalgorithm.astronomics.worlds.WorldRepository;

@DataJpaTest
public class WorldRepositoryTest {

    @Autowired
    private WorldRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }



}

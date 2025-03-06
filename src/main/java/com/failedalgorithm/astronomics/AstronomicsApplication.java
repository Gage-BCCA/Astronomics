package com.failedalgorithm.astronomics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AstronomicsApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(AstronomicsApplication.class, args);
    }

}

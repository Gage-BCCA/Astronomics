package com.failedalgorithm.astronomics.users.auth;

import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class ApiKeyController
{
    @Autowired
    ApiKeyRepository repository;

    @GetMapping
    public String testing()
    {
        return "You've reached the API endpoint!";
    }

    @GetMapping("/test")
    public Long testApiKey(@RequestHeader("x-api-key") String key, @RequestAttribute("userId") Long userId) {
        return userId;

    }
}

package com.failedalgorithm.astronomics.users.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ApiKeyController
{

    @GetMapping
    public String testing()
    {
        return "You've reached the API endpoint!";
    }
}

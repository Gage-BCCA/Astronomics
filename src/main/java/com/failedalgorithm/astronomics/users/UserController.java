package com.failedalgorithm.astronomics.users;

import com.failedalgorithm.astronomics.users.DTOs.UserDTO;
import com.failedalgorithm.astronomics.users.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class UserController
{

    @Autowired
    UserService service;

    @PostMapping("/register")
    public User createNewUser(@RequestBody User user)
    {
        return service.createNewUser(user);
    }

    @GetMapping("/retrieve-all")
    public Iterable<UserDTO> getAllUsers()
    {
        return service.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public SuccessResponse deleteUserById(@PathVariable Long id)
    {
        service.deleteUserById(id);
        return new SuccessResponse("Test");
    }

    @GetMapping
    public String testingEndpoint()
    {
        return "Yay!";
    }

}

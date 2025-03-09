package com.failedalgorithm.astronomics.users;

import com.failedalgorithm.astronomics.users.DTOs.UserDTO;
import com.failedalgorithm.astronomics.users.requests.CreateUserRequest;
import com.failedalgorithm.astronomics.users.requests.DeleteUserRequest;
import com.failedalgorithm.astronomics.users.requests.UpdateUserRequest;
import com.failedalgorithm.astronomics.users.responses.GenericSuccessResponse;
import com.failedalgorithm.astronomics.users.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class UserController
{

    @Autowired
    UserService service;

    @PostMapping("/register")
    public UserResponse createNewUser(@RequestBody CreateUserRequest request)
    {
        return service.createNewUser(request);
    }

    @GetMapping("/retrieve-all")
    public Iterable<UserDTO> getAllUsers()
    {
        return service.getAllUsers();
    }

    @GetMapping("/retrieve")
    public UserResponse getIndividualUser(@RequestAttribute("userId") Long userId)
    {
        return service.getIndividualUser(userId);
    }


    @DeleteMapping("/delete")
    public UserResponse deleteUserById(@RequestAttribute("userId") Long userId)
    {
        DeleteUserRequest request = new DeleteUserRequest();
        request.setUserId(userId);
        return service.deleteUserById(request);
    }

    @PutMapping("/update")
    public UserResponse updateUser(@RequestBody UpdateUserRequest request,
                                   @RequestAttribute("userId") Long userId)
    {
        request.setUserId(userId);
        return service.updateUser(request);
    }

    @GetMapping
    public String testingEndpoint()
    {
        return "Yay!";
    }

}

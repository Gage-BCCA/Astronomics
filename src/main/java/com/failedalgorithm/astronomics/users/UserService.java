package com.failedalgorithm.astronomics.users;

import com.failedalgorithm.astronomics.users.DTOs.UserDTO;
import com.failedalgorithm.astronomics.users.auth.ApiKey;
import com.failedalgorithm.astronomics.users.auth.ApiKeyRepository;
import com.failedalgorithm.astronomics.users.requests.CreateUserRequest;
import com.failedalgorithm.astronomics.users.requests.DeleteUserRequest;
import com.failedalgorithm.astronomics.users.requests.UpdateUserRequest;
import com.failedalgorithm.astronomics.users.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{

    @Autowired
    UserRepository repository;

    @Autowired
    ApiKeyRepository apiKeyRepository;

    public UserResponse createNewUser(CreateUserRequest request)
    {
        Optional<User> userQuery = repository.findByName(request.getUsername());
        if (userQuery.isPresent())
        {
            return new GenericErrorResponse("Failed", "Username already taken.");
        }

        User newUser = new User();
        newUser.setName(request.getUsername());
        newUser.setCallsign(request.getCallsign());
        newUser.setCredits(100L);
        newUser = repository.save(newUser);

        ApiKey apiKey = new ApiKey();
        apiKey.setUser(newUser);
        apiKeyRepository.save(apiKey);

        UserCreatedResponse response = new UserCreatedResponse();
        response.setStatus("Success");
        response.setMessage("User created");
        response.setApiKey(apiKey.getKey());

        return response;
    }

    public Iterable<UserDTO> getAllUsers()
    {
        Iterable<User> users = repository.findAll();

        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        for (User user : users)
        {
            UserDTO userDTO = new UserDTO(
                    user.getName(),
                    user.getCallsign(),
                    user.getCredits()
            );

            userDTOs.add(userDTO);
        }

        return userDTOs;
    }

    public UserResponse getIndividualUser(Long id)
    {
        Optional<User> userQuery = repository.findById(id);
        if (userQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "User account not found with calling agent");
        }
        User user = userQuery.get();

        UserDTO userDTO = new UserDTO(
                user.getName(),
                user.getCallsign(),
                user.getCredits()
        );

        SingleUserResponse response = new SingleUserResponse();
        response.setMessage("User account found");
        response.setStatus("Success");
        response.setUser(userDTO);
        return response;
    }

    public UserResponse updateUser(UpdateUserRequest request)
    {
        Optional<User> userQuery = repository.findById(request.getUserId());
        if (userQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "No matching user matching with the caller's ID");
        }
        User user = userQuery.get();
        if (request.getUsername() != null)
        {
            user.setName(request.getUsername());
        }

        if (request.getCallsign() != null)
        {
            user.setCallsign(request.getCallsign());
        }

        repository.save(user);

        return new GenericSuccessResponse("Success", "User updated");
    }

    public UserResponse deleteUserById(DeleteUserRequest request)
    {
        Optional<User> userQuery = repository.findById(request.getUserId());
        if (userQuery.isEmpty())
        {
            return new GenericErrorResponse("Failed", "User matching calling agent not found");
        }
        Optional<ApiKey> apiKeyQuery = apiKeyRepository.findByUserId(request.getUserId());
        if (apiKeyQuery.isPresent())
        {
            apiKeyRepository.delete(apiKeyQuery.get());
        }

        repository.deleteById(request.getUserId());
        return new GenericSuccessResponse("Success", "Your account has been deleted.");
    }

    public User getById(Long id)
    {
        Optional<User> userQuery = repository.findById(id);
        if (userQuery.isPresent())
        {
            return userQuery.get();
        }
        return null;
    }
}

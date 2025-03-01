package com.failedalgorithm.astronomics.users;

import com.failedalgorithm.astronomics.users.DTOs.UserDTO;
import com.failedalgorithm.astronomics.users.responses.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService
{

    @Autowired
    UserRepository repository;

    public User createNewUser(User user)
    {
        user.setSecret();
        return repository.save(user);
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

    public void updateName(UUID secret)
    {
        Optional<User> targetUser = repository.findBySecret(secret);
        if (targetUser.isPresent())
        {

        }
    }

    public void deleteUserById(Long id)
    {
        repository.deleteById(id);
    }
}

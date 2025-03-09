package com.failedalgorithm.astronomics.users.responses;

import com.failedalgorithm.astronomics.users.DTOs.UserDTO;

public class SingleUserResponse implements UserResponse
{
    //================================================================================
    // Properties
    //================================================================================
    private String status;
    private String message;
    private UserDTO user;


    //================================================================================
    // Constructors
    //================================================================================
    public SingleUserResponse()
    {
    }


    //================================================================================
    // Accessors
    //================================================================================
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public UserDTO getUser()
    {
        return user;
    }

    public void setUser(UserDTO user)
    {
        this.user = user;
    }
}

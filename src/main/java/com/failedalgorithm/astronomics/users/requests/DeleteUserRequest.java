package com.failedalgorithm.astronomics.users.requests;

public class DeleteUserRequest
{
    //================================================================================
    // Properties
    //================================================================================
    private Long userId;

    //================================================================================
    // Constructors
    //================================================================================
    public DeleteUserRequest()
    {
    }

    //================================================================================
    // Accessors
    //================================================================================
    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }
}

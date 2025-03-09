package com.failedalgorithm.astronomics.users.requests;

import org.hibernate.sql.Delete;

public class DeleteUserRequest
{
    //================================================================================
    // Properties
    //================================================================================
    private Long userId;

    //================================================================================
    // Constructors
    //================================================================================
    public DeleteUserRequest() {}

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

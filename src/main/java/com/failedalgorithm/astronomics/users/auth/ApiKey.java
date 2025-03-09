package com.failedalgorithm.astronomics.users.auth;

import com.failedalgorithm.astronomics.users.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "api_keys")
public class ApiKey
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key")
    private String key;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id")
    private User user;

    public ApiKey()
    {
        this.key = UUID.randomUUID().toString();
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public String getKey()
    {
        return key;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}

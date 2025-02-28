package com.failedalgorithm.astronomics.users.auth;

import com.failedalgorithm.astronomics.users.User;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "auth_keys")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key")
    private UUID key;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}

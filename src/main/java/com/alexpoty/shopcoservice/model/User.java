package com.alexpoty.shopcoservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user-table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String hashPassword;

    private String firstName;

    private String lastName;

    private String phone;
}

package com.example.blocodenotas.models.entitys;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "alteration_date")
    private LocalDateTime alterationDate;

    public User() {}

    public User(String name, String password, String email, LocalDateTime creationDate) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.creationDate = creationDate;
        this.alterationDate = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getAlterationDate() {
        return alterationDate;
    }

    public void setAlterationDate(LocalDateTime alterationDate) {this.alterationDate = alterationDate;}

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

}

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class User {
    private final String username;
    private final UUID id;
    private final String email;
    private final int number;
    private final String password;

    public User(
            @JsonProperty("name") String username,
            @JsonProperty("email") String email,
            @JsonProperty("id") UUID id,
            @JsonProperty("number") int number,
            @JsonProperty("password") String password
    ) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.number = number;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}

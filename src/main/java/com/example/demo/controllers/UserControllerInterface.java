package com.example.demo.controllers;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserControllerInterface {
    int insertUser(UUID id, User user);
    default int insertUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }

    List<User> selectAllUsers();

    Optional<User> selectPersonByID(UUID id);

    int deleteUserByID(UUID id);

    int updateUserByID(UUID id, User user);

}

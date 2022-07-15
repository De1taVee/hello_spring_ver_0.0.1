package com.example.demo.service;

import com.example.demo.controllers.UserControllerInterface;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserControllerInterface userControllerInterface;

    @Autowired
    public UserService(@Qualifier("postgres") UserControllerInterface userControllerInterface) {
        this.userControllerInterface = userControllerInterface;
    }

    public int addUser(User user){
        return userControllerInterface.insertUser(user);
    }

    public List<User> getAllUsers(){
        return userControllerInterface.selectAllUsers();
    }

    public Optional<User> getPersonByID(UUID id){
        return userControllerInterface.selectPersonByID(id);
    }

    public int deleteUser(UUID id){
        return userControllerInterface.deleteUserByID(id);
    }

    public int updateUser(UUID id, User newUser){
        return userControllerInterface.updateUserByID(id, newUser);
    }
    
}

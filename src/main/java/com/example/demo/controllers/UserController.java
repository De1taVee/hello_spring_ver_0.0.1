package com.example.demo.controllers;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("controllers/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void adduser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "{id}")
    public  User getUserByID(@PathVariable("id") UUID id) {
        return userService.getPersonByID(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUserByID(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }

    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") UUID id, @Validated @NonNull @RequestBody User userToUpdate){
        userService.updateUser(id, userToUpdate);
    }


}

package com.example.demo.controllers;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class HullUserController implements UserControllerInterface{
    private static List<User> dataBase = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        dataBase.add(
                new User(
                        user.getUsername(),
                        user.getEmail(),
                        id,
                        user.getNumber(),
                        user.getPassword()
                )
        );
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return dataBase;
    }

    @Override
    public Optional<User> selectPersonByID(UUID id) {
        return dataBase.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserByID(UUID id) {
        Optional<User> usr = selectPersonByID(id);
        if(usr.isEmpty()){return 0;}
        dataBase.remove(usr.get());
        return 1;
    }

    @Override
    public int updateUserByID(UUID id, User user) {
        return selectPersonByID(id).map(u -> {
            int indexOfUserToDelete = dataBase.indexOf(user);
            if (indexOfUserToDelete >= 0){
                dataBase.set(indexOfUserToDelete, user);
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}

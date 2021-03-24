package com.example.inovation.demo.service;

import com.example.inovation.demo.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    public void createUser(List<User> users);

    public Collection<User> getAllUsers();

    public Optional<User> findUserById(int id);

    public void deleleteUserById(int id);

    public void updateUser(User user);

    public void deleteAllUsers();

}

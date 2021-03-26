package com.example.inovation.demo.service;

import com.example.inovation.demo.dao.UserDao;
import com.example.inovation.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> createUser(List<User> users) {
       return userDao.saveAll(users);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void deleleteUserById(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userDao.deleteAll();
    }
}

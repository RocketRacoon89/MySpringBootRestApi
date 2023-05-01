package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(int id);

    public User getUserByName(String name);

    public void deleteUser(int id);
}

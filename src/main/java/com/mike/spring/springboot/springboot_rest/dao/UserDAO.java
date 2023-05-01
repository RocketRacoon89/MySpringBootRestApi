package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public User getUserByName(String name);

    public void deleteUser(int id);
}

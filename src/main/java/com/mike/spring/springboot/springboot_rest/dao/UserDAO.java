package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    public List<UserEntity> getAllUsers();

    public void saveUser(UserEntity user);

    public UserEntity getUser(int id);

    public UserEntity getUserByName(String name);

    public void deleteUser(int id);
}

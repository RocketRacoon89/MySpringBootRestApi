package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAll();

    UserEntity register(UserEntity user);

    UserEntity findById(int id);

    UserEntity getByEmail(String email);

    void delete(int id);
}

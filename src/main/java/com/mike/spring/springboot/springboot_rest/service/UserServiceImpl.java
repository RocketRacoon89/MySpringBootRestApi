package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.dao.UserDAOImpl;
import com.mike.spring.springboot.springboot_rest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAOImpl userDAO;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

//    @Override
//    @Transactional
//    public void saveUser(User user) {
//
//    }
//
//    @Override
//    @Transactional
//    public User getUser(int id) {
//        return null;
//    }
//
//    @Override
//    @Transactional
//    public void deleteUser(int id) {
//
//    }
}

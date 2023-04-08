package com.mike.spring.springboot.springboot_rest.controller;

import com.mike.spring.springboot.springboot_rest.entity.Event;
import com.mike.spring.springboot.springboot_rest.entity.User;
import com.mike.spring.springboot.springboot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> showAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}

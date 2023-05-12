package com.mike.spring.springboot.springboot_rest.rest;

import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import com.mike.spring.springboot.springboot_rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/users")
public class UserRestControllerV1 {

//    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping
    public void addUser(@RequestBody UserEntity user) {
        userService.register(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }

    @PutMapping
    public void updateUser(@RequestBody UserEntity user) {
        userService.register(user);
    }
}

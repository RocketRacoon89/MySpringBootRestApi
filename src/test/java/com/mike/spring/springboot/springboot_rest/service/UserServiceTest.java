package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.EventEntity;
import com.mike.spring.springboot.springboot_rest.entity.RoleEntity;
import com.mike.spring.springboot.springboot_rest.entity.Status;
import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import com.mike.spring.springboot.springboot_rest.repository.RoleRepository;
import com.mike.spring.springboot.springboot_rest.repository.UserRepository;
import com.mike.spring.springboot.springboot_rest.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    UserRepository userRepository = Mockito.mock(UserRepository.class);
    RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
    BCryptPasswordEncoder bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);

    UserService userService = new UserServiceImpl(userRepository, roleRepository, bCryptPasswordEncoder);

    public UserEntity getActiveUser() {
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("Test");
        user.setEmail("Test@test.com");
        user.setPassword("Test");
        user.setStatus(Status.ACTIVE);

        EventEntity event = Mockito.mock(EventEntity.class);
        List<EventEntity> eventList = new ArrayList<>();
        eventList.add(event);

        RoleEntity role = Mockito.mock(RoleEntity.class);
        List<RoleEntity> roleList = new ArrayList<>();
        roleList.add(role);

        user.setEvents(eventList);
        user.setRoles(roleList);

        return user;
    }

    @Test
    public void getAll() {
        List<UserEntity> listUsers = new ArrayList<>();
        listUsers.add(getActiveUser());
        when(userRepository.findAll()).thenReturn(listUsers);
        List<UserEntity> allUsers = userService.getAll();
        assertNotNull(allUsers.get(0).getId());
    }

    @Test
    public void failedGetAll() {
        try {
            when(userRepository.findAll()).thenThrow(new SQLException("SQL Exception"));
            userService.getAll();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("SQL Exception"));
        }
    }


}

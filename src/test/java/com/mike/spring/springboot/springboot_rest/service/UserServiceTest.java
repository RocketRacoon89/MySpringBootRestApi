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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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

    @Test
    public void register() {

    }

    @Test
    public void failedRegister() {

    }

    @Test
    public void findById() {
        when(userRepository.findById(isA(Integer.class))).thenReturn(Optional.ofNullable(getActiveUser()));
        UserEntity user = userService.findById(isA(Integer.class));
        assertNotNull(user.getId());
    }

    @Test
    public void failedFindById() {
        try {
            when(userRepository.findById(isA(Integer.class))).thenThrow(new NullPointerException());
            userService.findById(isA(Integer.class));
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void findByUsername() {
        when(userRepository.findByName(isA(String.class))).thenReturn(getActiveUser());
        UserEntity user = userService.findByUsername("Test");
        assertNotNull(user.getName());
    }

    @Test
    public void failedFindByUsername() {
        try {
            when(userRepository.findByName(isA(String.class))).thenThrow(new NullPointerException());
            userService.findByUsername(isA(String.class));
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void delete() {
        userService.delete(isA(Integer.class));
        Mockito.verify(userRepository, Mockito.times(1)).deleteById(isA(Integer.class));
    }

    @Test
    public void failedDelete() {
        try {
            Mockito.doThrow(new NullPointerException()).when(userRepository).deleteById(isA(Integer.class));
            userService.delete(isA(Integer.class));
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }


}

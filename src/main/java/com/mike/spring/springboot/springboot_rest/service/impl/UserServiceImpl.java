package com.mike.spring.springboot.springboot_rest.service.impl;

import com.mike.spring.springboot.springboot_rest.entity.RoleEntity;
import com.mike.spring.springboot.springboot_rest.entity.Status;
import com.mike.spring.springboot.springboot_rest.repository.RoleRepository;
import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import com.mike.spring.springboot.springboot_rest.repository.UserRepository;
import com.mike.spring.springboot.springboot_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    @Transactional
    public List<UserEntity> getAll() {
        List<UserEntity> result = userRepository.findAll();
        return result;
    }

    @Override
    @Transactional
    public UserEntity register(UserEntity user) {
        RoleEntity roleUser = roleRepository.findByName("ROLE_USER");
        List<RoleEntity> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);

        UserEntity registredUser = userRepository.save(user);

        return registredUser;
    }

    @Override
    @Transactional
    public UserEntity findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UserEntity findByUsername(java.lang.String name) {
        UserEntity result = userRepository.findByName(name);
        return result;
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);

    }
}

package com.mike.spring.springboot.springboot_rest.repository;

import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByName(String name);

}

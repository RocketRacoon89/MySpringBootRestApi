package com.mike.spring.springboot.springboot_rest.repository;

import com.mike.spring.springboot.springboot_rest.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    RoleEntity findByName(String name);

}

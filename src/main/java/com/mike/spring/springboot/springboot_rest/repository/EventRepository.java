package com.mike.spring.springboot.springboot_rest.repository;

import com.mike.spring.springboot.springboot_rest.entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Integer> {
}

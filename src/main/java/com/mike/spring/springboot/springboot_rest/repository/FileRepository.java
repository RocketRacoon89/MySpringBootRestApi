package com.mike.spring.springboot.springboot_rest.repository;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
}

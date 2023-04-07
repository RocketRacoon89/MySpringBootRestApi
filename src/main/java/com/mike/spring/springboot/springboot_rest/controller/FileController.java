package com.mike.spring.springboot.springboot_rest.controller;

import com.mike.spring.springboot.springboot_rest.entity.File;
import com.mike.spring.springboot.springboot_rest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/file")
    public List<File> shoAllFiles() {
        List<File> allFiles = fileService.getAllFiles();
        return allFiles;
    }
}

package com.mike.spring.springboot.springboot_rest.controller;

import com.mike.spring.springboot.springboot_rest.entity.File;
import com.mike.spring.springboot.springboot_rest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/file")
    public void addFile(@RequestBody File file) {
        fileService.saveFile(file);
    }

    @GetMapping("/file/{id}")
    public File getFile(@PathVariable int id) {
        File file = fileService.getFile(id);
        return file;
    }

    @DeleteMapping("/file/{id}")
    public void deleteFile(@PathVariable int id) {
        fileService.deleteFile(id);
    }

    @PutMapping("/file")
    public void updateFile(@RequestBody File file) {
        fileService.saveFile(file);
    }
}

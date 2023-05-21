package com.mike.spring.springboot.springboot_rest.rest;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;
import com.mike.spring.springboot.springboot_rest.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileRestControllerV1 {

//    @Autowired
    private FileService fileService;

    @Autowired
    public FileRestControllerV1(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping
    public List<FileEntity> getAllFiles() {
        return fileService.getAllFiles();
    }

    @PostMapping
    public void addFile(@RequestBody FileEntity file) {
        fileService.saveFile(file);
    }

    @GetMapping("/{id}")
    public FileEntity getFile(@PathVariable int id) {
        return fileService.getFile(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFile(@PathVariable int id) {
        fileService.deleteFile(id);
    }

    @PutMapping
    public void updateFile(@RequestBody FileEntity file) {
        fileService.saveFile(file);
    }
}

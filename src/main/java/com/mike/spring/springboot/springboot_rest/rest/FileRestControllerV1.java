package com.mike.spring.springboot.springboot_rest.rest;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;
import com.mike.spring.springboot.springboot_rest.service.FileService;
import com.mike.spring.springboot.springboot_rest.service.impl.S3Service;
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
    private S3Service s3Service;

    @Autowired
    public FileRestControllerV1(FileService fileService, S3Service s3Service) {
        this.fileService = fileService;
        this.s3Service=s3Service;
    }

    @GetMapping
    public List<FileEntity> getAllFiles() {
        return fileService.getAllFiles();
    }

    @PostMapping
    public void addFile(@RequestBody FileEntity file) {
        fileService.saveFile(file);
        this.uploadFile(file);
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

    public void uploadFile(@RequestBody FileEntity file) {
        String location = file.getLocation();
        String bucket = location.substring(0, location.indexOf("/"));
        String fileName = location.substring(location.indexOf("/")+1);
        s3Service.myUploadFile(bucket,fileName);
    }
}

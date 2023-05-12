package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;

import java.util.List;

public interface FileService {

    List<FileEntity> getAllFiles();

    FileEntity saveFile(FileEntity file);

    FileEntity getFile(int id);

    void deleteFile(int id);
}

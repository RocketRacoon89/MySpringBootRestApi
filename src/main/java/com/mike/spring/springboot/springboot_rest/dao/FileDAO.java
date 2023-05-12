package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;

import java.util.List;

public interface FileDAO {

    public List<FileEntity> getAllFiles();

    public void saveFile(FileEntity file);

    public FileEntity getFile(int id);

    public void deleteFile(int id);
}

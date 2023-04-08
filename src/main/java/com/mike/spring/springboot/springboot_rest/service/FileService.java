package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.File;

import java.util.List;

public interface FileService {

    public List<File> getAllFiles();

    public void saveFile(File file);

    public File getFile(int id);

    public void deleteFile(int id);
}

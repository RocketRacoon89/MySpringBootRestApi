package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.dao.FileDAOImpl;
import com.mike.spring.springboot.springboot_rest.entity.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDAOImpl fileDAO;

    @Override
    @Transactional
    public List<File> getAllFiles() {
        return fileDAO.getAllFiles();
    }
}
package com.mike.spring.springboot.springboot_rest.service.impl;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;
import com.mike.spring.springboot.springboot_rest.repository.FileRepository;
import com.mike.spring.springboot.springboot_rest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    @Transactional
    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    @Transactional
    public FileEntity saveFile(FileEntity file) {
        return fileRepository.save(file);
    }

    @Override
    @Transactional
    public FileEntity getFile(int id) {
        return fileRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteFile(int id) {
        fileRepository.deleteById(id);
    }
}

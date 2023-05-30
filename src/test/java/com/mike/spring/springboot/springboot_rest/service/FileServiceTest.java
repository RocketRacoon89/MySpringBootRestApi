package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;
import com.mike.spring.springboot.springboot_rest.entity.Status;
import com.mike.spring.springboot.springboot_rest.repository.FileRepository;
import com.mike.spring.springboot.springboot_rest.service.impl.FileServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

public class FileServiceTest {

    FileRepository fileRepository = Mockito.mock(FileRepository.class);
    FileService fileService = new FileServiceImpl(fileRepository);

    private FileEntity getActiveFile() {
        FileEntity file = new FileEntity();
        file.setId(1);
        file.setLocation("D");
        file.setStatus(Status.ACTIVE);
        return file;
    }

    @Test
    public void getAllFiles() {
        List<FileEntity> fileList = new ArrayList<>();
        fileList.add(getActiveFile());
        when(fileRepository.findAll()).thenReturn(fileList);
        List<FileEntity> allFileList = fileService.getAllFiles();
        assertNotNull(allFileList.get(0).getId());
    }

    @Test
    public void failedGetAllFiles() {
        try {
            when(fileRepository.findAll()).thenThrow(new SQLException("SQL Exception"));
            fileService.getAllFiles();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("SQL Exception"));
        }
    }

    @Test
    public void saveFile() {
        FileEntity fileSave = new FileEntity();
        fileSave.setId(2);
        fileSave.setLocation("TestLocation");
        fileSave.setStatus(Status.ACTIVE);

        when(fileRepository.save(any())).thenReturn(getActiveFile());

        FileEntity file = fileService.saveFile(fileSave);
        assertEquals(file.getStatus(), Status.ACTIVE);
        assertNotNull(file.getId());
    }

    @Test
    public void failedSaveFile() {
        FileEntity fileSave = new FileEntity();
        fileSave.setId(2);
        fileSave.setLocation("TestLocation");
        fileSave.setStatus(Status.ACTIVE);

        try {
            when(fileRepository.save(any())).thenThrow(new SQLException("SQL Exception"));
            fileService.saveFile(fileSave);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("SQL Exception"));
        }
    }

    @Test
    public void getFile() {
        when(fileRepository.findById(isA(Integer.class))).thenReturn(Optional.of(getActiveFile()));
        FileEntity file = fileService.getFile(isA(Integer.class));
        assertNotNull(file.getId());
    }

    @Test
    public void failedGetFile() {
        try {
            when(fileRepository.findById(isA(Integer.class))).thenThrow(new NullPointerException());
            fileService.getFile(isA(Integer.class));
        } catch (NullPointerException e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void deleteFile() {
        fileService.deleteFile(isA(Integer.class));
        Mockito.verify(fileRepository, Mockito.times(1)).deleteById(isA(Integer.class));
    }

    @Test
    public void failedDeleteFile() {
        try {
            Mockito.doThrow(new NullPointerException()).when(fileRepository).deleteById(isA(Integer.class));
            fileService.deleteFile(isA(Integer.class));
        } catch (NullPointerException e) {
            assertTrue(e instanceof NullPointerException);
        }
    }
}

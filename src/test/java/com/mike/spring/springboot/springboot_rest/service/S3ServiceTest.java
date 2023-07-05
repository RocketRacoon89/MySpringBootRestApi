package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.service.impl.S3Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class S3ServiceTest {

    @Autowired
    private S3Service s3Service;

    @Test
    public void testCreateBucket() {

        s3Service.createBucket();
    }

    @Test
    public void testListBuckets(){
        s3Service.listBuckets();
    }

    @Test
    public void testUploadFile(){
        s3Service.uploadFile();
    }

    @Test
    public void testListFiles(){
        s3Service.listFiles();
    }

}

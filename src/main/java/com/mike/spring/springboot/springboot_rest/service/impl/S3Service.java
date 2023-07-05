package com.mike.spring.springboot.springboot_rest.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Slf4j
@Service
public class S3Service {

    private final AmazonS3 s3client;

    @Autowired
    public S3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    public void createBucket() {
        String bucketName = "liketutorial";

        if (s3client.doesBucketExistV2(bucketName)) {
            log.info("Bucket {} already exists, use a different name", bucketName);
            return;
        }

        s3client.createBucket(bucketName);
    }

    public void listBuckets(){
        List<Bucket> buckets = s3client.listBuckets();
        log.info("buckets: {}", buckets);
    }

    @SneakyThrows
    public void uploadFile() {
        String bucketName = "liketutorial";
        ClassLoader loader = S3Service.class.getClassLoader();
        File file = new File(loader.getResource("liketutorial.txt").getFile());
        s3client.putObject(
                bucketName,
                "liketutorial.txt",
                file);
    }

//    My Version
    @SneakyThrows
    public void myUploadFile(String bucketName, String fileName) {
        ClassLoader loader = S3Service.class.getClassLoader();
        File file = new File(loader.getResource(fileName).getFile());
        s3client.putObject(
                bucketName,
                fileName,
                file);
}

    public void listFiles() {
        String bucketName = "liketutorial";

        ObjectListing objects = s3client.listObjects(bucketName);
        for(S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
            log.info("File name: {}", objectSummary.getKey());
        }
    }

    @SneakyThrows
    public void downloadFile() {
        String bucketName = "liketutorial";

        S3Object s3object = s3client.getObject(bucketName, "liketutorial.txt");
        S3ObjectInputStream inputStream = s3object.getObjectContent();
        File file = new File("<PUT_DESIRED_PATH_HERE>");

        FileCopyUtils.copy(inputStream, new FileOutputStream(file));
    }

    public void deleteFile() {
        String bucketName = "liketutorial";
        s3client.deleteObject(bucketName,"liketutorial.txt");
    }


}

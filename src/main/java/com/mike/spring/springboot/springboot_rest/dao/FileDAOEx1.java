package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.FileEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class FileDAOEx1 implements FileDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<FileEntity> getAllFiles() {

        Session session = entityManager.unwrap(Session.class);

        Query<FileEntity> query = session.createQuery("from File where status = \"ACTIVE\"", FileEntity.class);

        List<FileEntity> allFiles = query.getResultList();

        return allFiles;
    }

    @Override
    public void saveFile(FileEntity file) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(file);
    }

    @Override
    public FileEntity getFile(int id) {

        Session session = entityManager.unwrap(Session.class);

        FileEntity file = session.get(FileEntity.class, id);

        return file;
    }

    @Override
    public void deleteFile(int id) {

        Session session = entityManager.unwrap(Session.class);

//        session.createQuery("update File set status = \'DELETED\' where id = :id", File.class).setParameter("id", id).executeUpdate();

        session.createQuery("update File set status = \'DELETED\' where id = :id").setParameter("id", id).executeUpdate();


    }
}

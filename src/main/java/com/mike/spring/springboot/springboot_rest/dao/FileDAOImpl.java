package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.Event;
import com.mike.spring.springboot.springboot_rest.entity.File;
import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class FileDAOImpl implements FileDAO{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<File> getAllFiles() {

        Session session = entityManager.unwrap(Session.class);

        Query<File> query = session.createQuery("from File", File.class);

        List<File> allFiles = query.getResultList();

        return allFiles;
    }

    @Override
    public void saveFile(File file) {

        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(file);
    }

    @Override
    public File getFile(int id) {

        Session session = entityManager.unwrap(Session.class);

        File file = session.get(File.class, id);

        return file;
    }

    @Override
    public void deleteFile(int id) {

        Session session = entityManager.unwrap(Session.class);

        File file = session.get(File.class, id);

        session.delete(file);

    }
}

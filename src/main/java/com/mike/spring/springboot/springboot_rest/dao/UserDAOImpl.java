package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("from User", User.class);

        List<User> allUsers = query.getResultList();

        return allUsers;
    }

//    @Override
//    public void saveUser(User user) {
//
//    }
//
//    @Override
//    public User getUser(int id) {
//        return null;
//    }
//
//    @Override
//    public void deleteUser(int id) {
//
//    }
}
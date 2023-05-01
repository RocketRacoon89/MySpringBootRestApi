package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDAOEx1 implements UserDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {

        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("from User", User.class);

        List<User> allUsers = query.getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("update User set status = \"DELETED\" where id = :id", User.class).setParameter("id", id).executeUpdate();
    }

    @Override
    public User getUserByName(String name) {
        Session session = entityManager.unwrap(Session.class);

        Query<User> query = session.createQuery("from User where name = :name", User.class)
                .setParameter("name", name);

        User user = query.getResultList().get(0);

        return user;
    }
}

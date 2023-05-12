package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.UserEntity;
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
    public List<UserEntity> getAllUsers() {

        Session session = entityManager.unwrap(Session.class);

        Query<UserEntity> query = session.createQuery("from User", UserEntity.class);

        List<UserEntity> allUsers = query.getResultList();

        return allUsers;
    }

    @Override
    public void saveUser(UserEntity user) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(user);
    }

    @Override
    public UserEntity getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        UserEntity user = session.get(UserEntity.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("update User set status = \"DELETED\" where id = :id", UserEntity.class).setParameter("id", id).executeUpdate();
    }

    @Override
    public UserEntity getUserByName(String name) {
        Session session = entityManager.unwrap(Session.class);

        Query<UserEntity> query = session.createQuery("from User where name = :name", UserEntity.class)
                .setParameter("name", name);

        UserEntity user = query.getResultList().get(0);

        return user;
    }
}

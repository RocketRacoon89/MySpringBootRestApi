package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.EventEntity;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EventRepository implements EventDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<EventEntity> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);

        Query<EventEntity> query = session.createQuery("from Event", EventEntity.class);

        List<EventEntity> allEvents = query.getResultList();

        return allEvents;
    }

    @Override
    public EventEntity getEvent(int id) {
        Session session = entityManager.unwrap(Session.class);
        EventEntity event = session.get(EventEntity.class, id);
        return event;
    }

    @Override
    public void saveEvent(EventEntity event) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(event);
    }

    @Override
    public void deleteEvent(int id) {
        Session session = entityManager.unwrap(Session.class);

        EventEntity event = session.get(EventEntity.class, id);

        session.delete(event);

    }
}

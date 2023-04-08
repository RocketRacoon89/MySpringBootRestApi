package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.Event;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);

        Query<Event> query = session.createQuery("from Event", Event.class);

        List<Event> allEvents = query.getResultList();

        return allEvents;
    }

    @Override
    public Event getEvent(int id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        return event;
    }

    @Override
    public void saveEvent(Event event) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(event);
    }

    @Override
    public void deleteEvent(int id) {
        Session session = entityManager.unwrap(Session.class);

        Event event = session.get(Event.class, id);

        session.delete(event);

    }
}

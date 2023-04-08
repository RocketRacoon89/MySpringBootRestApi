package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.dao.EventDAOImpl;
import com.mike.spring.springboot.springboot_rest.entity.Event;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventDAOImpl eventDAO;

    @Override
    @Transactional
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    @Override
    @Transactional
    public void saveEvent(Event event) {
        eventDAO.saveEvent(event);

    }

    @Override
    @Transactional
    public Event getEvent(int id) {
        Event event = eventDAO.getEvent(id);
        return event;
    }

    @Override
    @Transactional
    public void deleteEvent(int id) {
        eventDAO.deleteEvent(id);
    }


}

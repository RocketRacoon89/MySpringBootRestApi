package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.Event;

import java.util.List;

public interface EventDAO {

    public List<Event> getAllEvents();

    public Event getEvent(int id);

    public void saveEvent(Event event);

    public void deleteEvent(int id);
}

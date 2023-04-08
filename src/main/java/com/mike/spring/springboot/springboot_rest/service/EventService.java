package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.Event;

import java.util.List;

public interface EventService {

    public List<Event> getAllEvents();

    public void saveEvent(Event event);

    public Event getEvent(int id);

    public void deleteEvent(int id);
}

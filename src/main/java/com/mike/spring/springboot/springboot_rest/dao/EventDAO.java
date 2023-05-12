package com.mike.spring.springboot.springboot_rest.dao;

import com.mike.spring.springboot.springboot_rest.entity.EventEntity;

import java.util.List;

public interface EventDAO {

    public List<EventEntity> getAllEvents();

    public EventEntity getEvent(int id);

    public void saveEvent(EventEntity event);

    public void deleteEvent(int id);
}

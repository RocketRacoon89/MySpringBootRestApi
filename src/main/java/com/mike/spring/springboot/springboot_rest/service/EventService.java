package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.EventEntity;

import java.util.List;

public interface EventService {

    List<EventEntity> getAllEvents();

    EventEntity saveEvent(EventEntity event);

    EventEntity getEvent(int id);

    void deleteEvent(int id);
}

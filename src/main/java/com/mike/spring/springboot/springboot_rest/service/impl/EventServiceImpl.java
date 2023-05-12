package com.mike.spring.springboot.springboot_rest.service.impl;

import com.mike.spring.springboot.springboot_rest.repository.EventRepository;
import com.mike.spring.springboot.springboot_rest.entity.EventEntity;
import com.mike.spring.springboot.springboot_rest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    @Override
    @Transactional
    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    @Transactional
    public EventEntity saveEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public EventEntity getEvent(int id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}

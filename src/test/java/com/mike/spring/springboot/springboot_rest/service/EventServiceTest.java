package com.mike.spring.springboot.springboot_rest.service;

import com.mike.spring.springboot.springboot_rest.entity.*;
import com.mike.spring.springboot.springboot_rest.repository.EventRepository;
import com.mike.spring.springboot.springboot_rest.service.impl.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

public class EventServiceTest {

    EventRepository eventRepository = Mockito.mock(EventRepository.class);
    EventService eventService = new EventServiceImpl(eventRepository);

    private EventEntity getActiveEvent() {
        RoleEntity role = new RoleEntity();
        role.setId(1);
        role.setName("USER");
        List<RoleEntity> listRoles = new ArrayList<>();
        listRoles.add(role);

        FileEntity file = new FileEntity();
        file.setId(1);
        file.setLocation("Test");
        file.setStatus(Status.ACTIVE);

        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("Test");
        user.setPassword("Test");
        user.setRoles(listRoles);
        user.setEmail("test@test.com");
        user.setStatus(Status.ACTIVE);

        EventEntity event = new EventEntity();
        event.setId(1);
        event.setFile(file);
        event.setStatus(Status.ACTIVE);
        event.setUser(user);

        return event;
    }

    @Test
    public void getAllEvents() {
        List<EventEntity> listEvents = new ArrayList<>();
        listEvents.add(getActiveEvent());
        when(eventRepository.findAll()).thenReturn(listEvents);
        List<EventEntity> allEvents = eventService.getAllEvents();
        assertNotNull(allEvents.get(0).getId());
    }

    @Test
    public void failedGetAllEvents() {
        try {
            when(eventRepository.findAll()).thenThrow(new SQLException("SQL Exception"));
            eventService.getAllEvents();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("SQL Exception"));
        }
    }

    @Test
    public void saveEvent() {
        EventEntity event = getActiveEvent();
        when(eventRepository.save(any())).thenReturn(getActiveEvent());
        EventEntity newEvent = eventService.saveEvent(event);
        assertNotNull(newEvent.getId());
    }

    @Test
    public void failedSaveEvent() {
        EventEntity event = getActiveEvent();
        try{
            when(eventRepository.save(any())).thenThrow(new SQLException("SQL Exception"));
            eventService.saveEvent(event);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("SQL Exception"));
        }
    }

    @Test
    public void getEvent() {
        when(eventRepository.findById(isA(Integer.class))).thenReturn(Optional.of(getActiveEvent()));
        EventEntity event = eventService.getEvent(isA(Integer.class));
        assertNotNull(event.getId());
    }

    @Test
    public void failedGetEvent() {
        try {
            when(eventRepository.findById(isA(Integer.class))).thenThrow(new NullPointerException());
            eventService.getEvent(isA(Integer.class));
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

    @Test
    public void deleteEvent() {
        eventService.deleteEvent(isA(Integer.class));
        Mockito.verify(eventRepository, Mockito.times(1)).deleteById(isA(Integer.class));
    }

    @Test
    public void failedDeleteEvent() {
        try {
            Mockito.doThrow(new NullPointerException()).when(eventRepository).deleteById(isA(Integer.class));
            eventService.deleteEvent(isA(Integer.class));
        } catch (Exception e) {
            assertTrue(e instanceof NullPointerException);
        }
    }

}

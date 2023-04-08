package com.mike.spring.springboot.springboot_rest.controller;

import com.mike.spring.springboot.springboot_rest.entity.Event;
import com.mike.spring.springboot.springboot_rest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public List<Event> getAllEvents() {
        List<Event> allEvents = eventService.getAllEvents();
        return allEvents;
    }

    @PostMapping("/event")
    public void addEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
    }

    @GetMapping("/event/{id}")
    public Event getEvent(@PathVariable int id) {
        Event event = eventService.getEvent(id);
        return event;
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

    @PutMapping("/event")
    public void updateEvent(@RequestBody Event event) {
        eventService.saveEvent(event);
    }

}

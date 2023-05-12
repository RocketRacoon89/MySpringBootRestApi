package com.mike.spring.springboot.springboot_rest.rest;

import com.mike.spring.springboot.springboot_rest.entity.EventEntity;
import com.mike.spring.springboot.springboot_rest.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/V1/events")
public class EventRestControllerV1 {

//    @Autowired
    private EventService eventService;

    @GetMapping
    public List<EventEntity> getAllEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping
    public void addEvent(@RequestBody EventEntity event) {
        eventService.saveEvent(event);
    }

    @GetMapping("/{id}")
    public EventEntity getEvent(@PathVariable int id) {
        return eventService.getEvent(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable int id) {
        eventService.deleteEvent(id);
    }

    @PutMapping
    public void updateEvent(@RequestBody EventEntity event) {
        eventService.saveEvent(event);
    }

}

package com.example.event_scheduling.controller;

import com.example.event_scheduling.dto.EventRequestDTO;
import com.example.event_scheduling.dto.EventResponseDTO;
import com.example.event_scheduling.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController
{
    private final EventService eventService;

    public EventController(EventService eventService)
    {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<?> getAllEvents()
    {
        List<EventResponseDTO> dto = eventService.getAllEvents();

        if (dto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEventById(@PathVariable Long id) {
        EventResponseDTO dto = eventService.getEventById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@Valid @RequestBody EventRequestDTO eventRequestDTO)
    {
        var createdEvent = eventService.createEvent(eventRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }
}

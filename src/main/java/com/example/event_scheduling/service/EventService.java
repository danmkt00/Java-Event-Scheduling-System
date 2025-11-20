package com.example.event_scheduling.service;

import com.example.event_scheduling.dto.*;
import com.example.event_scheduling.exception.*;
import com.example.event_scheduling.mapper.EventMapper;
import com.example.event_scheduling.model.Event;
import com.example.event_scheduling.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService
{
    private EventRepository eventRepository;
    private EventMapper eventMapper;

    public EventService(EventRepository eventRepository)
    {
        this.eventRepository = eventRepository;
        this.eventMapper = new EventMapper();
    }

    public List<EventResponseDTO> getAllEvents()
    {
        return eventRepository.findAll().stream().map(eventMapper::convertFromEntityToEventResponseDto).toList();
    }

    public EventResponseDTO createEvent(EventRequestDTO eventRequestDTO) {
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime start = eventRequestDTO.getStartDateTime();
        LocalDateTime end = eventRequestDTO.getEndDateTime();

        if (start.isBefore(now)) {
            throw new EventDateInPastException("Event start date must be in the future.");
        }

        if (end.isBefore(start)) {
            throw new EventEndBeforeStartException("Event end date must not be before start date.");
        }

        Event event = eventMapper.convertFromEventRequestDtoToEntity(eventRequestDTO);

        Event savedEvent = eventRepository.save(event);

        return eventMapper.convertFromEntityToEventResponseDto(savedEvent);
    }
}

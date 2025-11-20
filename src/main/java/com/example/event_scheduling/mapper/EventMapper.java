package com.example.event_scheduling.mapper;

import com.example.event_scheduling.dto.EventRequestDTO;
import com.example.event_scheduling.dto.EventResponseDTO;
import com.example.event_scheduling.model.Event;

public class EventMapper {

    public Event convertFromEventRequestDtoToEntity(EventRequestDTO eventRequestDTO) {
        Event event = new Event();

        event.setTitle(eventRequestDTO.getTitle());
        event.setStartDateTime(eventRequestDTO.getStartDateTime());
        event.setEndDateTime(eventRequestDTO.getEndDateTime());
        event.setCapacity(eventRequestDTO.getCapacity());

        return event;
    }

    public EventResponseDTO convertFromEntityToEventResponseDto(Event event) {
        EventResponseDTO eventResponseDto = new EventResponseDTO();

        eventResponseDto.setId(event.getId());
        eventResponseDto.setTitle(event.getTitle());
        eventResponseDto.setStartDateTime(event.getStartDateTime());
        eventResponseDto.setEndDateTime(event.getEndDateTime());
        eventResponseDto.setCapacity(event.getCapacity());

        return eventResponseDto;
    }

}
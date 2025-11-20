package com.example.event_scheduling.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public class EventRequestDTO {
    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Start time is mandatory")
    private LocalDateTime startDateTime;

    @NotNull(message = "End time is mandatory")
    private LocalDateTime endDateTime;

    @NotNull(message = "Capacity is mandatory")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}

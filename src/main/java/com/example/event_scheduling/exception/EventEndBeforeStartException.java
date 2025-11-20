package com.example.event_scheduling.exception;

public class EventEndBeforeStartException extends RuntimeException{
    public EventEndBeforeStartException(String message) {
        super(message);
    }
}

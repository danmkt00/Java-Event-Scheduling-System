package com.example.event_scheduling.exception;

public class EventDateInPastException extends RuntimeException
{
    public EventDateInPastException(String message)
    {
        super(message);
    }
}

package com.example.communityproject.service.exception.models;

public class InvalidParkingTimeException extends RuntimeException{
    @Override
    public String getMessage() {
        return "The end time must be bigger than start time";
    }
}

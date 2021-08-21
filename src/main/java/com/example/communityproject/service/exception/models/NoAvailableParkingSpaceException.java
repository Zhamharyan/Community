package com.example.communityproject.service.exception.models;

public class NoAvailableParkingSpaceException extends RuntimeException{
    @Override
    public String getMessage() {
        return "No available parking space";
    }
}

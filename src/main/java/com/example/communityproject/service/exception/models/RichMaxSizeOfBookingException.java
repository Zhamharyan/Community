package com.example.communityproject.service.exception.models;

public class RichMaxSizeOfBookingException extends RuntimeException{
    @Override
    public String getMessage() {
        return "You already have 4 booked parking space";
    }
}

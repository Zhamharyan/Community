package com.example.communityproject.service.exception.models;

public class ParkingStartTimeNotMentionedException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Please mention parking stt time";
    }
}

package com.example.communityproject.service.exception.models;

public class InvalidCommunityException extends RuntimeException{

    @Override
    public String getMessage() {
        return "You are not allowed to book parking space int this community";
    }
}

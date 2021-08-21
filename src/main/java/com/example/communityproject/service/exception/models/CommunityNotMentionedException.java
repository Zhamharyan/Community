package com.example.communityproject.service.exception.models;

public class CommunityNotMentionedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Please mention which community parking space do you want to book";
    }
}

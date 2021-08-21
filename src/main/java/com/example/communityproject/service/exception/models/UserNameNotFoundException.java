package com.example.communityproject.service.exception.models;

public class UserNameNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "UserNameNotFound";
    }
}

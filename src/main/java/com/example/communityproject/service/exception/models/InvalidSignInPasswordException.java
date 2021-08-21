package com.example.communityproject.service.exception.models;

public class InvalidSignInPasswordException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Invalid password";
    }
}

package com.example.communityproject.service.exception.models;

public class InvalidRegisterUserName extends RuntimeException{
    @Override
    public String getMessage() {
        return "The register user must contain username";
    }
}

package com.example.communityproject.service.exception.models;

public class InvalidRegisterPassword extends RuntimeException{
    @Override
    public String getMessage() {
        return "The register user must contain password";
    }
}

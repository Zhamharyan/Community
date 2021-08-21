package com.example.communityproject.service.exception.models;

public class RoleNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Role Not found";
    }
}

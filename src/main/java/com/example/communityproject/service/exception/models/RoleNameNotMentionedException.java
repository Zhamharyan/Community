package com.example.communityproject.service.exception.models;

public class RoleNameNotMentionedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Role name not mentioned to create";
    }
}

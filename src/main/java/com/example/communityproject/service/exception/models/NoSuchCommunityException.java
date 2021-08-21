package com.example.communityproject.service.exception.models;

public class NoSuchCommunityException extends RuntimeException{
    @Override
    public String getMessage() {
        return "No such community";
    }
}

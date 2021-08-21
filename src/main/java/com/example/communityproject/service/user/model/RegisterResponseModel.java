package com.example.communityproject.service.user.model;

public class RegisterResponseModel {
    private Long id;
    private String authBasicToken;

    public RegisterResponseModel(Long id, String authBasicToken) {
        this.id = id;
        this.authBasicToken = authBasicToken;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAuthBasicToken() {
        return authBasicToken;
    }
    public void setAuthBasicToken(String authBasicToken) {
        this.authBasicToken = authBasicToken;
    }
}

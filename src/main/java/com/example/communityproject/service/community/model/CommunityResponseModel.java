package com.example.communityproject.service.community.model;

public class CommunityResponseModel {
    private Long communityId;
    private String communityName;

    public CommunityResponseModel(Long communityId, String communityName) {
        this.communityId = communityId;
        this.communityName = communityName;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}

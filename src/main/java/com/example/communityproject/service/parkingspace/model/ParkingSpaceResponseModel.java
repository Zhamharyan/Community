package com.example.communityproject.service.parkingspace.model;

public class ParkingSpaceResponseModel {

    private Long id;
    private Long communityId;

    public ParkingSpaceResponseModel(Long id, Long communityId) {
        this.id = id;
        this.communityId = communityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }
}

package com.example.communityproject.rest.controller.user.model;

import com.example.communityproject.persistence.user.model.User;

import java.util.Date;

public class UserParkingSpaceConnectionModel {

    private User user;
    private int communityId;
    private Date start;
    private Date end;

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}

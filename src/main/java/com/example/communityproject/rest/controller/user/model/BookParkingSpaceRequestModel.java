package com.example.communityproject.rest.controller.user.model;

import java.util.Date;

public class BookParkingSpaceRequestModel {

    private int communityId;
    private Date start;
    private Date end;


    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
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

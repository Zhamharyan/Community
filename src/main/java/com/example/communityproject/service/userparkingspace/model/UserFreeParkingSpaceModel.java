package com.example.communityproject.service.userparkingspace.model;

import com.example.communityproject.persistence.parkingspace.model.ParkingSpace;
import com.example.communityproject.persistence.user.model.User;

import java.util.Date;

public class UserFreeParkingSpaceModel {
    private User user;
    private ParkingSpace freeParkingSpace;
    private Date start;
    private Date end;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingSpace getFreeParkingSpace() {
        return freeParkingSpace;
    }

    public void setFreeParkingSpace(ParkingSpace freeParkingSpace) {
        this.freeParkingSpace = freeParkingSpace;
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

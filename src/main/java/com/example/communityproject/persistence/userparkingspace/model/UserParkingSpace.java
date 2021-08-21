package com.example.communityproject.persistence.userparkingspace.model;

import com.example.communityproject.persistence.parkingspace.model.ParkingSpace;
import com.example.communityproject.persistence.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    @ManyToOne
    private ParkingSpace parkingSpace;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date start;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date end;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
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

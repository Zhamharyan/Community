package com.example.communityproject.persistence.parkingspace.model;

import com.example.communityproject.persistence.community.model.Community;
import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ParkingSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Community community;

    @OneToMany(mappedBy = "parkingSpace")
    private List<UserParkingSpace> userParkingSpaceList = new ArrayList<>();




    public List<UserParkingSpace> getUserParkingSpaceList() {
        return userParkingSpaceList;
    }

    public void setUserParkingSpaceList(List<UserParkingSpace> userParkingSpaceList) {
        this.userParkingSpaceList = userParkingSpaceList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

}

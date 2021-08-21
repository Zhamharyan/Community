package com.example.communityproject.service.userparkingspace;

import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;
import com.example.communityproject.service.userparkingspace.model.UserFreeParkingSpaceModel;

import java.util.List;

public interface UserParkingSpaceService {
    void connectUserToParkingSpace(UserFreeParkingSpaceModel model);
    List<UserParkingSpace> getAllByUser(User user);
}

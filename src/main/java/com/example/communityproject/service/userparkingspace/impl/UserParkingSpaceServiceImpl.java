package com.example.communityproject.service.userparkingspace.impl;

import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.persistence.userparkingspace.UserParkingSpaceRepository;
import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;
import com.example.communityproject.service.userparkingspace.UserParkingSpaceService;
import com.example.communityproject.service.userparkingspace.model.UserFreeParkingSpaceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserParkingSpaceServiceImpl implements UserParkingSpaceService {
    private UserParkingSpaceRepository userParkingSpaceRepository;

    public UserParkingSpaceServiceImpl(UserParkingSpaceRepository userParkingSpaceRepository) {
        this.userParkingSpaceRepository = userParkingSpaceRepository;
    }

    public void connectUserToParkingSpace(UserFreeParkingSpaceModel model) {
        UserParkingSpace userParkingSpace = new UserParkingSpace();
        userParkingSpace.setUser(model.getUser());
        userParkingSpace.setParkingSpace(model.getFreeParkingSpace());
        userParkingSpace.setStart(model.getStart());
        userParkingSpace.setEnd(model.getEnd());
        userParkingSpaceRepository.save(userParkingSpace);
    }

    public List<UserParkingSpace> getAllByUser(User user){
        return userParkingSpaceRepository.getAllByUser(user);
    }
}

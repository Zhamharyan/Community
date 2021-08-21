package com.example.communityproject.service.parkingspace;

import com.example.communityproject.persistence.parkingspace.model.ParkingSpace;
import com.example.communityproject.rest.controller.parkingspace.model.CreateParkingSpaceRequestModel;
import com.example.communityproject.service.parkingspace.model.ParkingSpaceResponseModel;

import java.util.Date;

public interface ParkingSpaceService {
    ParkingSpaceResponseModel createParkingSpace(CreateParkingSpaceRequestModel model);
    ParkingSpace getFreeSpace(Date start, Date end, int communityId);

}

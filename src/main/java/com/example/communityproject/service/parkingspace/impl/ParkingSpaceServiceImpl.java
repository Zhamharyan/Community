package com.example.communityproject.service.parkingspace.impl;

import com.example.communityproject.persistence.community.model.Community;
import com.example.communityproject.persistence.parkingspace.ParkingSpaceRepository;
import com.example.communityproject.persistence.parkingspace.model.ParkingSpace;
import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;
import com.example.communityproject.rest.controller.parkingspace.model.CreateParkingSpaceRequestModel;
import com.example.communityproject.service.community.CommunityService;
import com.example.communityproject.service.exception.models.InvalidParkingTimeException;
import com.example.communityproject.service.exception.models.NoSuchCommunityException;
import com.example.communityproject.service.exception.models.ParkingStartTimeNotMentionedException;
import com.example.communityproject.service.parkingspace.ParkingSpaceService;
import com.example.communityproject.service.parkingspace.model.ParkingSpaceResponseModel;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ParkingSpaceServiceImpl implements ParkingSpaceService {
    private ParkingSpaceRepository parkingSpaceRepository;
    private CommunityService communityService;

    public ParkingSpaceServiceImpl(CommunityService communityService, ParkingSpaceRepository parkingSpaceRepository) {
        this.parkingSpaceRepository = parkingSpaceRepository;
        this.communityService = communityService;
    }

    public ParkingSpaceResponseModel createParkingSpace(CreateParkingSpaceRequestModel model) {
        ParkingSpace parkingSpace = new ParkingSpace();
        Community community = communityService.getCommunityById(model.getCommunityId());
        if (community == null) {
            throw new NoSuchCommunityException();
        }
        parkingSpace.setCommunity(community);
        parkingSpaceRepository.save(parkingSpace);
        ParkingSpaceResponseModel responseModel = new ParkingSpaceResponseModel(parkingSpace.getId(), parkingSpace.getCommunity().getId());
        return responseModel;
    }

    public ParkingSpace getFreeSpace(Date start, Date end, int communityId) {
        if(start == null){
            throw new ParkingStartTimeNotMentionedException();
        }
        if(end != null && end.getTime() <= start.getTime()){
            throw new InvalidParkingTimeException();
        }
        List<ParkingSpace> parkingSpaceList = parkingSpaceRepository.findAllByCommunityId(new Long(communityId));
        for (int i = 0; i < parkingSpaceList.size(); i++) {
            ParkingSpace current = parkingSpaceList.get(i);
            List<UserParkingSpace> userParkingSpaceList = current.getUserParkingSpaceList();
            if (userParkingSpaceList.size() == 0) {
                return current;
            }
            boolean available = true;
            for (int j = 0; j < userParkingSpaceList.size(); j++) {
                UserParkingSpace old = userParkingSpaceList.get(i);
                if (end == null) {
                    if (old.getEnd() == null) {
                        if (start.getTime() - old.getStart().getTime() <= 60000 * 30) {
                            available = false;
                        }
                    } else {
                        if (start.getTime() >= old.getStart().getTime()
                                && start.getTime() <= old.getEnd().getTime()) {
                            available = false;
                        }
                    }
                } else {
                    if (old.getEnd() != null) {
                        if (start.getTime() >= old.getStart().getTime() && start.getTime() <= old.getEnd().getTime()) {
                            available = false;
                        }
                        if (end.getTime() >= old.getStart().getTime() && end.getTime() <= old.getEnd().getTime()) {
                            available = false;
                        }
                        if (start.getTime() <= old.getStart().getTime() && end.getTime() >= old.getEnd().getTime()) {
                            available = false;
                        }
                    } else {
                        if (start.getTime() - old.getStart().getTime() <= 60000 * 30) {
                            available = false;
                        }
                    }
                }
            }
            if (available) {
                return current;
            }
        }
        return null;
    }
}

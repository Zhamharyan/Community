package com.example.communityproject.utils.scheduledtasks;

import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;
import com.example.communityproject.persistence.userparkingspace.UserParkingSpaceRepository;
import com.example.communityproject.persistence.user.UserRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CleanFinishedParkingSpaces {

    private UserRepository userRepository;
    private UserParkingSpaceRepository userParkingSpaceRepository;

    public CleanFinishedParkingSpaces(UserParkingSpaceRepository userParkingSpaceRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userParkingSpaceRepository = userParkingSpaceRepository;
    }

    @Scheduled(fixedDelay = 1000*60*30)
    public void cleanFreeSpaces() throws InterruptedException {
        List<UserParkingSpace> all = userParkingSpaceRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getEnd() == null
                    && ((new Date().getTime()) - (all.get(i).getStart().getTime())) >= 60000) {
                userParkingSpaceRepository.deleteById(all.get(i).getId());
            }
        }
    }
}

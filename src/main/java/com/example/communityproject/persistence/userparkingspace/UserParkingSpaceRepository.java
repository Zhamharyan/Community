package com.example.communityproject.persistence.userparkingspace;

import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserParkingSpaceRepository extends JpaRepository<UserParkingSpace,Long> {
    List<UserParkingSpace> getAllByUser(User user);

}

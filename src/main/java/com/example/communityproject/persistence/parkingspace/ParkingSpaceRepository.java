package com.example.communityproject.persistence.parkingspace;

import com.example.communityproject.persistence.parkingspace.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace,Long> {

    List<ParkingSpace> findAllByCommunityId(Long id);
    // List<ParkingSpace> findAllByCommunityId(Long id);
}

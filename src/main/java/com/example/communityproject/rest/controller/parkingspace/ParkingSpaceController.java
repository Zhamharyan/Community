package com.example.communityproject.rest.controller.parkingspace;

import com.example.communityproject.rest.controller.parkingspace.model.CreateParkingSpaceRequestModel;
import com.example.communityproject.service.parkingspace.ParkingSpaceService;
import com.example.communityproject.service.parkingspace.model.ParkingSpaceResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ParkingSpaceController {

    private ParkingSpaceService parkingSpaceService;
    public ParkingSpaceController(ParkingSpaceService parkingSpaceService){
        this.parkingSpaceService = parkingSpaceService;
    }

    @PostMapping("/parkingSpace/create")
    public ResponseEntity<ParkingSpaceResponseModel> createParkingSpace(@RequestBody CreateParkingSpaceRequestModel model){
        ParkingSpaceResponseModel parkingSpace = parkingSpaceService.createParkingSpace(model);
        return ResponseEntity.ok(parkingSpace);
    }


}

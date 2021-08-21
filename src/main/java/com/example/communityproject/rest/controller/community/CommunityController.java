package com.example.communityproject.rest.controller.community;

import com.example.communityproject.rest.controller.community.model.CommunityRequestModel;
import com.example.communityproject.service.community.CommunityService;
import com.example.communityproject.service.community.model.CommunityResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CommunityController {

    private CommunityService communityService;

    public CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/community/create")
    public ResponseEntity<Object> createCommunity(@RequestBody CommunityRequestModel requestModel) {
        CommunityResponseModel communityResponseModel = communityService.createCommunity(requestModel);
        return ResponseEntity.ok(communityResponseModel);
    }
}

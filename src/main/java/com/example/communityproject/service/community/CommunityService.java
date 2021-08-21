package com.example.communityproject.service.community;

import com.example.communityproject.persistence.community.model.Community;
import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.rest.controller.community.model.CommunityRequestModel;
import com.example.communityproject.service.community.model.CommunityResponseModel;

import java.util.List;

public interface CommunityService {
    CommunityResponseModel createCommunity(CommunityRequestModel model);
    Community getCommunityById(int id);
    List<Community> getAllCommunitiesContainingUser(User user);
}

package com.example.communityproject.service.community.impl;

import com.example.communityproject.persistence.community.model.Community;
import com.example.communityproject.persistence.community.CommunityRepository;
import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.rest.controller.community.model.CommunityRequestModel;
import com.example.communityproject.service.community.CommunityService;
import com.example.communityproject.service.community.model.CommunityResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {

    private CommunityRepository communityRepository;

    public CommunityServiceImpl(CommunityRepository communityRepository){
        this.communityRepository = communityRepository;
    }

    public CommunityResponseModel createCommunity(CommunityRequestModel model){
        Community community = new Community();
        community.setCommunityName(model.getCommunityName());
        communityRepository.save(community);
        CommunityResponseModel communityResponseModel = new CommunityResponseModel(community.getId(),community.getCommunityName());
        return communityResponseModel;
    }

    public Community getCommunityById(int id){
        return communityRepository.getCommunityById(new Long(id));
    }


    public List<Community> getAllCommunitiesContainingUser(User user) {
        return communityRepository.getAllByUserListIsContaining(user);
    }
}

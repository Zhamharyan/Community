package com.example.communityproject.service.user;

import com.example.communityproject.rest.controller.role.model.ConnectRoleToUserRequestModel;
import com.example.communityproject.rest.controller.user.model.JoinToCommunityRequestModel;
import com.example.communityproject.rest.controller.user.model.SignInRequestModel;
import com.example.communityproject.rest.controller.user.model.UserRegisterRequestModel;
import com.example.communityproject.rest.controller.user.model.UserParkingSpaceConnectionModel;
import com.example.communityproject.service.user.model.RegisterResponseModel;

public interface UserService {
    RegisterResponseModel registerUser(UserRegisterRequestModel model);
    String signIn(SignInRequestModel model);
    void connectRoleToUser(ConnectRoleToUserRequestModel model);
    void connectUserToParkingSpace(UserParkingSpaceConnectionModel model);
    void joinToCommunity(JoinToCommunityRequestModel model);
}

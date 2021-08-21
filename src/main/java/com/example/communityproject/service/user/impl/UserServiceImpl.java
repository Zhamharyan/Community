package com.example.communityproject.service.user.impl;

import com.example.communityproject.config.securityconfig.model.CustomUserDetails;
import com.example.communityproject.persistence.community.model.Community;
import com.example.communityproject.persistence.parkingspace.model.ParkingSpace;
import com.example.communityproject.persistence.role.model.UserRole;
import com.example.communityproject.persistence.user.UserRepository;
import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.persistence.userparkingspace.model.UserParkingSpace;
import com.example.communityproject.rest.controller.role.model.ConnectRoleToUserRequestModel;
import com.example.communityproject.rest.controller.user.model.JoinToCommunityRequestModel;
import com.example.communityproject.rest.controller.user.model.SignInRequestModel;
import com.example.communityproject.rest.controller.user.model.UserRegisterRequestModel;
import com.example.communityproject.rest.controller.user.model.UserParkingSpaceConnectionModel;
import com.example.communityproject.service.community.CommunityService;
import com.example.communityproject.service.exception.models.*;
import com.example.communityproject.service.parkingspace.ParkingSpaceService;
import com.example.communityproject.service.role.RoleService;
import com.example.communityproject.service.user.UserService;
import com.example.communityproject.service.user.model.RegisterResponseModel;
import com.example.communityproject.service.userparkingspace.UserParkingSpaceService;
import com.example.communityproject.service.userparkingspace.model.UserFreeParkingSpaceModel;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private RoleService roleService;
    private UserParkingSpaceService userParkingSpaceService;
    private ParkingSpaceService parkingSpaceService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private CommunityService communityService;

    public UserServiceImpl(CommunityService communityService, UserParkingSpaceService userParkingSpaceService, ParkingSpaceService parkingSpaceService, RoleService roleService, UserRepository userRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.userParkingSpaceService = userParkingSpaceService;
        this.parkingSpaceService = parkingSpaceService;
        this.roleService = roleService;
        this.passwordEncoder = bCryptPasswordEncoder;
        this.communityService = communityService;
    }

    public RegisterResponseModel registerUser(UserRegisterRequestModel model) {
        if (model.getUserName() == null) {
            throw new InvalidRegisterUserName();
        }
        if (model.getPassword() == null) {
            throw new InvalidRegisterPassword();
        }
        User user = new User();
        user.setUserName(model.getUserName());
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        User savedUser = userRepository.save(user);
        String stringToEncode = model.getUserName() + ":" + model.getPassword();
        String basicAuthToken = Base64.getEncoder().encodeToString(stringToEncode.getBytes());
        RegisterResponseModel responseModel = new RegisterResponseModel(user.getId(), basicAuthToken);
        return responseModel;
    }

    public String signIn(SignInRequestModel model) {
        User user = userRepository.findUserByUserName(model.getUserName());
        if (user == null) {
            throw new UserNameNotFoundException();
        }
        String userEncodedPassword = user.getPassword();
        if (!passwordEncoder.matches(userEncodedPassword, model.getPassword())) {
            throw new InvalidSignInPasswordException();
        }
        byte[] bytesToEncode = (user.getUserName() + ":" + model.getPassword()).getBytes();
        String authBaseToken = Base64.getEncoder().encodeToString(bytesToEncode);
        return authBaseToken;
    }


    public void connectRoleToUser(ConnectRoleToUserRequestModel model) {
        User user = userRepository.getUserById(new Long(model.getUserId()));
        if (user == null) {
            throw new UserNameNotFoundException();
        }
        UserRole role = roleService.findRoleById(model.getRoleId());
        if (role == null) {
            throw new RoleNotFoundException();
        }
        user.getUserRoles().add(role);
        userRepository.save(user);
    }


    public void connectUserToParkingSpace(UserParkingSpaceConnectionModel model) {
        if (model.getCommunityId() == 0) {
            throw new CommunityNotMentionedException();
        }
        Community communityById = communityService.getCommunityById(model.getCommunityId());
        if (communityById == null) {
            throw new NoSuchCommunityException();
        }
        List<Community> userCommunityList = communityService.getAllCommunitiesContainingUser(model.getUser());
        if (userCommunityList.stream().anyMatch(each -> each.getId().equals(new Long(model.getCommunityId())))) {
            throw new InvalidCommunityException();
        }
        List<UserParkingSpace> allByUser = userParkingSpaceService.getAllByUser(model.getUser())
                .stream().filter(each -> each.getParkingSpace().getCommunity().getId().equals(new Long(model.getCommunityId())))
                .collect(Collectors.toList());
        if (allByUser.size() == 4) {
            throw new RichMaxSizeOfBookingException();
        }
        ParkingSpace freeSpace = parkingSpaceService.getFreeSpace(model.getStart(), model.getEnd(), model.getCommunityId());
        if (freeSpace == null) {
            throw new NoAvailableParkingSpaceException();
        }
        UserFreeParkingSpaceModel userFreeParkingSpaceModel = new UserFreeParkingSpaceModel();
        userFreeParkingSpaceModel.setUser(model.getUser());
        userFreeParkingSpaceModel.setFreeParkingSpace(freeSpace);
        userFreeParkingSpaceModel.setEnd(model.getEnd());
        userFreeParkingSpaceModel.setStart(model.getStart());
        userParkingSpaceService.connectUserToParkingSpace(userFreeParkingSpaceModel);
    }

    public void joinToCommunity(JoinToCommunityRequestModel model) {
        CustomUserDetails currentUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Community communityById = communityService.getCommunityById(model.getCommunityId());
        if (communityById == null) {
            throw new NoSuchCommunityException();
        }
        User currentUser = currentUserDetails.getUser();
        currentUser.getCommunityList().add(communityById);
        userRepository.save(currentUser);
    }

}

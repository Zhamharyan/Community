package com.example.communityproject.rest.controller.user;

import com.example.communityproject.config.securityconfig.model.CustomUserDetails;
import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.rest.controller.role.model.ConnectRoleToUserRequestModel;
import com.example.communityproject.rest.controller.user.model.BookParkingSpaceRequestModel;
import com.example.communityproject.rest.controller.user.model.JoinToCommunityRequestModel;
import com.example.communityproject.rest.controller.user.model.SignInRequestModel;
import com.example.communityproject.rest.controller.user.model.UserRegisterRequestModel;
import com.example.communityproject.rest.controller.user.model.UserParkingSpaceConnectionModel;
import com.example.communityproject.service.parkingspace.ParkingSpaceService;
import com.example.communityproject.service.user.UserService;
import com.example.communityproject.service.user.model.RegisterResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;
    private ParkingSpaceService parkingSpaceService;

    public UserController(ParkingSpaceService parkingSpaceService, UserService userService) {
        this.userService = userService;
        this.parkingSpaceService = parkingSpaceService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<RegisterResponseModel> registerUser(@RequestBody UserRegisterRequestModel request) {
        RegisterResponseModel responseModel = userService.registerUser(request);
        return ResponseEntity.ok(responseModel);
    }

    @PostMapping("/user/connectToUser")
    public ResponseEntity<Object> connectRoleToUser(@RequestBody ConnectRoleToUserRequestModel request) {
        userService.connectRoleToUser(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/signIn")
    public ResponseEntity<String> signIn(@RequestBody SignInRequestModel request) {
        String authBaseToken = userService.signIn(request);
        return ResponseEntity.ok(authBaseToken);
    }

    @PostMapping("/user/bookParkingSpace")
    public ResponseEntity<Object> bookParkingSpace(@RequestBody BookParkingSpaceRequestModel request) {
        CustomUserDetails principal = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = principal.getUser();
        UserParkingSpaceConnectionModel mod = new UserParkingSpaceConnectionModel();
        mod.setUser(currentUser);
        mod.setCommunityId(request.getCommunityId());
        mod.setStart(request.getStart());
        mod.setEnd(request.getEnd());
        userService.connectUserToParkingSpace(mod);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/joinToCommunity")
    public ResponseEntity<Object> joinToCommunity(@RequestBody JoinToCommunityRequestModel request){
        userService.joinToCommunity(request);
        return ResponseEntity.ok().build();
    }
}

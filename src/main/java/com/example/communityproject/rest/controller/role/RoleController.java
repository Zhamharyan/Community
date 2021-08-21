package com.example.communityproject.rest.controller.role;

import com.example.communityproject.rest.controller.role.model.CreateRoleRequestModel;
import com.example.communityproject.service.role.RoleService;
import com.example.communityproject.service.role.model.RoleResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RoleController {
    private RoleService roleService;
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @PostMapping("/role/create")
    public ResponseEntity<RoleResponseModel> createRole(@RequestBody CreateRoleRequestModel model){
        RoleResponseModel responseModel = roleService.createRole(model);
        return ResponseEntity.ok(responseModel);
    }



}

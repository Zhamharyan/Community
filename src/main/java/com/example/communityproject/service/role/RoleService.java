package com.example.communityproject.service.role;

import com.example.communityproject.persistence.role.model.UserRole;
import com.example.communityproject.rest.controller.role.model.CreateRoleRequestModel;
import com.example.communityproject.service.role.model.RoleResponseModel;

public interface RoleService {
    UserRole findRoleById(int id);
    RoleResponseModel createRole(CreateRoleRequestModel model);
}

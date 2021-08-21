package com.example.communityproject.service.role.impl;

import com.example.communityproject.persistence.role.RoleRepository;
import com.example.communityproject.persistence.role.model.UserRole;
import com.example.communityproject.rest.controller.role.model.CreateRoleRequestModel;
import com.example.communityproject.service.exception.models.RoleNameNotMentionedException;
import com.example.communityproject.service.role.RoleService;
import com.example.communityproject.service.role.model.RoleResponseModel;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;

    }

    public RoleResponseModel createRole(CreateRoleRequestModel model) {
        if (model.getRoleName() == null) {
            throw new RoleNameNotMentionedException();
        }
        UserRole role = new UserRole();
        role.setName(model.getRoleName());
        roleRepository.save(role);
        RoleResponseModel responseModel = new RoleResponseModel(role.getId(), role.getName());
        return responseModel;
    }

    public UserRole findRoleById(int id) {
        return roleRepository.getUserRoleById(new Long(id));
    }


}

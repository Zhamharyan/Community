package com.example.communityproject.persistence.role;

import com.example.communityproject.persistence.role.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole,Long> {
    UserRole getUserRoleById(Long id);
}

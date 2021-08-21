package com.example.communityproject.persistence.user;

import com.example.communityproject.persistence.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUserName(String userName);
    User getUserById(Long id);
}

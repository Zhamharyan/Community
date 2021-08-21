package com.example.communityproject.persistence.community;

import com.example.communityproject.persistence.community.model.Community;
import com.example.communityproject.persistence.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community,Long> {
    Community getCommunityById(Long id);

    List<Community> getAllByUserListIsContaining(User user);

}

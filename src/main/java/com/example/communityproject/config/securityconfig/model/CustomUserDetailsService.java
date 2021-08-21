package com.example.communityproject.config.securityconfig.model;

import com.example.communityproject.persistence.user.model.User;
import com.example.communityproject.persistence.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        User user = userRepository.findUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("There is no user with such username");
        }
        customUserDetails.setUser(user);
        return customUserDetails;
    }


}

package com.example.travel_buddy_app.services;


import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepo.findByUserNameOrUserEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

        // Since there are no roles, we'll create an empty collection for the authorities
        Set<GrantedAuthority> authorities = Collections.emptySet();

        return new org.springframework.security.core.userdetails.User(user.getUserEmail(),
                user.getUserPassword(),
                authorities);
    }

}
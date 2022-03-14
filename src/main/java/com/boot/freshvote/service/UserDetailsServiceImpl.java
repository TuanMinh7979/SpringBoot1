package com.boot.freshvote.service;

import com.boot.freshvote.domain.UserModel;
import com.boot.freshvote.repo.UserRepo;
import com.boot.freshvote.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("Incorect username or password!!!");


        CustomSecurityUser customuser = new CustomSecurityUser(user);
        System.out.println(customuser.getUsername() + "-" + customuser.getPassword() + customuser.getAuthorities());
        return customuser;

    }
}

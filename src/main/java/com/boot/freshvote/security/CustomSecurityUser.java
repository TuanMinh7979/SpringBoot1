package com.boot.freshvote.security;

import com.boot.freshvote.domain.UserModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
//khong phai la bean cung co autowired dc


public class CustomSecurityUser extends UserModel implements UserDetails {
    //    public CustomSecurityUser(Long id, String username, String password, String name, Set<Authority> authorities) {
//        super(id, username, password, name, authorities);
//    }


    public CustomSecurityUser() {

    }

    public CustomSecurityUser(UserModel userModel) {
        this.setUsername1(userModel.getUsername1());
        this.setPassword1(userModel.getPassword1());
        this.setAuthorities1(userModel.getAuthorities1());
        this.setId(userModel.getId());
        this.setName1(userModel.getName1());

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return super.getAuthorities1();
    }

    @Override
    public String getPassword() {
        return super.getPassword1();
    }

    @Override
    public String getUsername() {
        return super.getUsername1();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

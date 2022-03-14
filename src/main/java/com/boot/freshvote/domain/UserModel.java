package com.boot.freshvote.domain;

import com.boot.freshvote.security.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    private String username;
    private String password;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    Set<Authority> authorities = new HashSet<>();




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername1() {
        return username;
    }

    public void setUsername1(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password;
    }

    public void setPassword1(String password) {
        this.password = password;
    }

    public String getName1() {
        return name;
    }

    public void setName1(String name) {
        this.name = name;
    }

    public Set<Authority> getAuthorities1() {
        return authorities;
    }

    public void setAuthorities1(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}

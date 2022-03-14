package com.boot.freshvote.security;

import com.boot.freshvote.domain.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authority implements GrantedAuthority {
    @Id
    private Long id;
    private String authorityname;
    @ManyToOne
    private UserModel user;

    @Override
    public String getAuthority() {
        return this.authorityname;
    }

    public void setAuthorityname(String authorityname) {
        this.authorityname = authorityname;
    }
}

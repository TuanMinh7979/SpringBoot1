package com.boot.freshvote.service;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.junit.Assert.*;


class UserDetailsServiceImplTest {

    @Test
    public void generate_encrypted_password() {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        String rawpassword = "123";
        String encodedPassword = enc.encode(rawpassword);
        System.out.println(encodedPassword);
        assertThat(rawpassword, CoreMatchers.not(encodedPassword));
    }

}
package com.boot.freshvote.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConf extends WebSecurityConfigurerAdapter {
    //(1)Sẽ tự nhận UserDetailsServiceImpl

    @Autowired
    private UserDetailsService userDetailsService;
    //(1)


    //    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(getPasswordEncoder())
//                .withUser("tuanuser")
//                .password(getPasswordEncoder().encode("123"))
//                .roles("USER");
//
//
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequest->anymatcherhasny->anyrequest->waytosecure
        http.csrf().disable()
                .authorizeRequests()

                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                //Các request còn lại muốn vào chỉ cần đăng nhập thành công
//                .anyRequest().hasRole("User")
                //các request còn lại ngoài đăng nhập còn phải có role User mới có thể vào
                .and()

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/db")
                .permitAll().and()

                .logout().logoutUrl("/logout").permitAll();

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.
                userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

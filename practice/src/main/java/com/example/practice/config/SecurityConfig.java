package com.example.practice.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring()
                .antMatchers("/img/**")
                .antMatchers("/js/**")
                .antMatchers("/css/**")
                .antMatchers("resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                    .authorizeRequests()
                        .antMatchers("/login", "/signUp").permitAll()
                        .antMatchers("/userPage").hasRole("USER")
                        .antMatchers("/adminPage").hasRole("ADMIN")
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/user_access")
                        .failureUrl("/main")
                .and()
                    .logout()
                        .logoutSuccessUrl("/login")
                .and()
                    .csrf().disable();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}

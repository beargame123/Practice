package com.example.practice.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UserInfoDto {
    @Email
    private String email;
    private String password;
    private String auth;
}

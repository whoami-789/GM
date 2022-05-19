package com.example.gm.payload.request;

import lombok.Data;

import javax.validation.constraints.Email;


@Data
public class SignUpRequest {

    @Email()
    private String email;
    private String name;
    private String surname;
    private String bdate;
    private String password;
    private String confirmPassword;
}

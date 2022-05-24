package com.example.gm.payload.request;

import com.example.gm.anotations.PasswordMatches;
import com.example.gm.anotations.ValidEmail;
import lombok.Data;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@PasswordMatches
public class SignUpRequest {

    @Email(message = "It should have email format")
    @NotBlank(message = "Email is required")
    @ValidEmail
    private String email;

    @NotEmpty(message = "Please enter your name")
    private String name;

    @NotEmpty(message = "Please enter your surname")
    private String surname;

    /*@NotEmpty(message = "Please enter your username")
    private String username;*/

    @NotEmpty(message = "Please enter your birth date")
    private String bdate;

    @NotEmpty(message = "Please enter your birth date")
    private String phoneNumber;

    @NotEmpty(message = "Password is required")
    @Size(min = 6)
    private String password;
    private String confirmPassword;
}

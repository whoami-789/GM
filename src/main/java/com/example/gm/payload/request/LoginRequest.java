package com.example.gm.payload.request;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;


@Data
public class LoginRequest {

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}

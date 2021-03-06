package com.example.gm.payload.response;

import lombok.Getter;

@Getter
public class InvalidLoginResponse {

    private String email;
    private String password;

    public InvalidLoginResponse() {
        this.email = "invalid email";
        this.password = "invalid Password";
    }
}

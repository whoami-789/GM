package com.example.gm.models.enums;

public enum Roles {
    ROLE_USER, ROLE_DOCTOR, ROLE_REGISTRATOR;

    public String getAuthority() {
        return name();
    }
}

package com.example.gm.repositories;

import com.example.gm.models.Users;

public interface UserRepository {
    Users findByEmail(String email);
}

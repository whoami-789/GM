package com.example.gm.repositories;

import com.example.gm.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);
}

package com.example.gm.repositories;

import com.example.gm.models.User;
import com.example.gm.models.Zapis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByEmail(String email);
}

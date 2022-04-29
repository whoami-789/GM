package com.example.gm.repositories;

import com.example.gm.models.Zapis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZapisRepository extends JpaRepository<Zapis, Long> {
    List<Zapis> findById(String id);
}

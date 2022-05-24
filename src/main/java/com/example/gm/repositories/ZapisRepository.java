package com.example.gm.repositories;

import com.example.gm.models.Category;
import com.example.gm.models.User;
import com.example.gm.models.Zapis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZapisRepository extends JpaRepository<Zapis, Long> {
    Optional<Zapis> findZapisById(Long id);

    List<Zapis> findAllByIdU(User user);
    List<Zapis> findByIdC(Category category);

    Optional<Zapis> findZapisByIdAAndUserAndCategory(Long id, User user, Category category);
}

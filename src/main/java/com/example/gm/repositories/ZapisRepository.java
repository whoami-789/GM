package com.example.gm.repositories;

import com.example.gm.models.Category;
import com.example.gm.models.User;
import com.example.gm.models.Zapis;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZapisRepository extends JpaRepository<Zapis, Long> {
    @NotNull Optional<Zapis> findAllById(@NotNull Long id);

    List<Zapis> findById(User user);

    List<Zapis> findById(Category category);
}

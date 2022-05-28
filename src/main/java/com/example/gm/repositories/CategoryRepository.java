package com.example.gm.repositories;

import com.example.gm.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByTitle(String title);
    Optional<Category> findCategoryById(Long title);

    List<Category> findAllByOrderById();
}

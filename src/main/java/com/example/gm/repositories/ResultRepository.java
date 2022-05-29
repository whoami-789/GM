package com.example.gm.repositories;

import com.example.gm.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    Optional<Result> findByUserId (Long id);

    Optional<Result> findByZapisId (Long id);
}

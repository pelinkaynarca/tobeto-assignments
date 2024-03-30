package com.tobeto.java4aPair4.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.java4aPair4.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByNameIgnoreCase(String name);
}

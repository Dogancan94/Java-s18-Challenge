package com.workintech.libraryapp.repository;

import com.workintech.libraryapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

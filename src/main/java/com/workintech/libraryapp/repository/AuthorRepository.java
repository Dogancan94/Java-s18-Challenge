package com.workintech.libraryapp.repository;

import com.workintech.libraryapp.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}

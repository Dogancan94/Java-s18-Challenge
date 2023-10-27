package com.workintech.libraryapp.repository;

import com.workintech.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

package com.workintech.libraryapp.service;

import com.workintech.libraryapp.entity.Book;

public interface BookService {
    Book findById(long id);
    Book save(Book book);
}

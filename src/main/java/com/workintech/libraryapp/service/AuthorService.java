package com.workintech.libraryapp.service;

import com.workintech.libraryapp.entity.Author;

public interface AuthorService {
    Author findById(long id);
    Author save(Author author);
}

package com.workintech.libraryapp.service;

import com.workintech.libraryapp.entity.Author;
import com.workintech.libraryapp.entity.Book;
import com.workintech.libraryapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }
        throw new RuntimeException("Book with given id is not exist");
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}

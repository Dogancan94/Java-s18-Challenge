package com.workintech.libraryapp.service;

import com.workintech.libraryapp.entity.Book;
import com.workintech.libraryapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }
        throw new RuntimeException("Book with given id is not exist");
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}

package com.workintech.libraryapp.controller;

import com.workintech.libraryapp.dto.AuthorResponse;
import com.workintech.libraryapp.dto.AuthorResponseWithBooks;
import com.workintech.libraryapp.dto.BookResponse;
import com.workintech.libraryapp.entity.Author;
import com.workintech.libraryapp.entity.Book;
import com.workintech.libraryapp.service.AuthorService;
import com.workintech.libraryapp.service.AuthorServiceImpl;
import com.workintech.libraryapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Spring Data Rest
@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/")
    public Author save(@RequestBody Author author){
        return authorService.save(author);
    }

    @PostMapping("/{bookId}")
    public AuthorResponseWithBooks save(@RequestBody Author author, @PathVariable long bookId){
        Book book = bookService.findById(bookId);
        author.addBook(book);
        book.setAuthor(author);
        authorService.save(author);
        List<BookResponse> bookResponseList = new ArrayList<>();
        //bu kodu util paketinin altına taşı
        for(Book authorBook: author.getBooks()){
            bookResponseList.add(new BookResponse(authorBook.getId(), authorBook.getName(),
                    authorBook.getCategory().getName(),
                    new AuthorResponse(author.getId(),
                            author.getFirstName() + " " + author.getLastName())));
        }
        return new AuthorResponseWithBooks(bookResponseList);

    }
}

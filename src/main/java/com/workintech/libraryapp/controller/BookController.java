package com.workintech.libraryapp.controller;

import com.workintech.libraryapp.dto.AuthorResponse;
import com.workintech.libraryapp.dto.BookResponse;
import com.workintech.libraryapp.entity.Author;
import com.workintech.libraryapp.entity.Book;
import com.workintech.libraryapp.entity.Category;
import com.workintech.libraryapp.service.AuthorService;
import com.workintech.libraryapp.service.BookService;
import com.workintech.libraryapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;
    private CategoryService categoryService;
    private AuthorService authorService;

    public BookController(BookService bookService,
                          CategoryService categoryService,
                          AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId){
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(),
                book.getCategory().getName(),
                null);
    }

    @PostMapping("/saveByAuthor")
    public BookResponse save(@RequestBody Book book,
                             @RequestParam long categoryId,
                             @RequestParam long authorId){
        //Saving Category Bi-directional
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        //Saving Author Bi-directional
        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);

        bookService.save(book);
        return new BookResponse(book.getId(), book.getName(),
                book.getCategory().getName(),
                new AuthorResponse(author.getId(),
                        (author.getFirstName() + " " +author.getLastName())));
    }
}

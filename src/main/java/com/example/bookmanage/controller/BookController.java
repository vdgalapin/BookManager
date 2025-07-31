package com.example.bookmanage.controller;

// Imports the entity class for Book
import com.example.bookmanage.model.Book;
// Imports the service class for Book
import com.example.bookmanage.service.BookService;
// Imports the Spring Framework's RestController and RequestMapping
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public Book getBookId(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
package com.example.bookmanage.service;

// Imports the entity class for Book
import com.example.bookmanage.model.Book;
import com.example.bookmanage.repository.BookRepository;

// Imports the Spring Framework's Services
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public Book getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }    


    public void deleteBook(Long id) {
        repo.deleteById(id);
    }

    
}
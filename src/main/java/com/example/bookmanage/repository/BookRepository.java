package com.example.bookmanage.repository;

// This is the entity class for Book
import com.example.bookmanage.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // This interface will automatically provide CRUD operations for Book entities
    // Additional query methods can be defined here if needed
    // For example, you can add a method to find books by title
    
}
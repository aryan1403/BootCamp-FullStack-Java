package com.example.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Book;
@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByTitle(String title);

    List<Book> findByAuthor(String author);

    Book findByIsbn(String isbn);

    List<Book> findByPublicationYear(int publicationYear);
}

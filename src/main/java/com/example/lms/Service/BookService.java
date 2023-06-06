package com.example.lms.Service;

import com.example.lms.Model.Books;
import com.example.lms.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Books> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Books createBook(Books book) {
        return bookRepository.save(book);
    }

    public Books updateBook(String id, Books updatedBook) {
        Optional<Books> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            updatedBook.setId(id);
            return bookRepository.save(updatedBook);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }

    public void deleteBook(String id) {
        Optional<Books> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Book not found with id: " + id);
        }
    }
}

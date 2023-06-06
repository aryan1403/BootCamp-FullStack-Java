package com.example.lms.Controller;

import com.example.lms.Model.Books;
import com.example.lms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable String id) {
        Optional<Books> book = bookService.getBookById(id);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        Books createdBook = bookService.createBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable String id, @RequestBody Books updatedBook) {
        try {
            Books book = bookService.updateBook(id, updatedBook);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

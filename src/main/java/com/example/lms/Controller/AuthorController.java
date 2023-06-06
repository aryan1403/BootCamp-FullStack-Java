package com.example.lms.Controller;

import com.example.lms.Model.Authors;
import com.example.lms.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Authors>> getAllAuthors() {
        List<Authors> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable String authorId) {
        Optional<Authors> authorOptional = authorService.getAuthorById(authorId);
        return authorOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Authors> createAuthor(@RequestBody Authors author) {
        Authors createdAuthor = authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Authors> updateAuthor(@PathVariable String authorId, @RequestBody Authors author) {
        Authors updatedAuthor = authorService.updateAuthor(authorId, author);
        return updatedAuthor != null ? ResponseEntity.ok(updatedAuthor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String authorId) {
        boolean deleted = authorService.deleteAuthor(authorId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

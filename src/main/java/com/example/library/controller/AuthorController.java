package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Author;
import com.example.library.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private final AuthorService authorService;

    
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.addAuthor(author);
    }

    @PutMapping("/{id}")
    public void updateAuthor(@PathVariable String id, @RequestBody Author author) {
        author.setId(id);
        authorService.updateAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable String id) {
        authorService.deleteAuthor(id);
    }

    @GetMapping("/search")
    public Author searchAuthors(@RequestParam String keyword) {
        return authorService.searchAuthors(keyword);
    }
}
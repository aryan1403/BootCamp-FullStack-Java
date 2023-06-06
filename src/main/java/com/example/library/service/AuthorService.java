package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(String id) {
        return authorRepository.findById(id);
    }
    
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }

    public Author searchAuthors(String name) {
        return authorRepository.findByName(name);
    }
}

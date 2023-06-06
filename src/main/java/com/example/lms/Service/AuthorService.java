package com.example.lms.Service;

import com.example.lms.Model.Authors;
import com.example.lms.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Authors> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Authors> getAuthorById(String authorId) {
        return authorRepository.findById(authorId);
    }

    public Authors createAuthor(Authors author) {
        return authorRepository.save(author);
    }

    public Authors updateAuthor(String authorId, Authors author) {
        Optional<Authors> existingAuthorOptional = authorRepository.findById(authorId);
        if (existingAuthorOptional.isPresent()) {
            Authors existingAuthor = existingAuthorOptional.get();
            existingAuthor.setAuthorName(author.getAuthorName());
            existingAuthor.setBio(author.getBio());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public boolean deleteAuthor(String authorId) {
        Optional<Authors> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isPresent()) {
            authorRepository.delete(authorOptional.get());
            return true;
        }
        return false;
    }
}

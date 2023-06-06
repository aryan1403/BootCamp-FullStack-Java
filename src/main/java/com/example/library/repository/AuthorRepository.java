package com.example.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Author;
@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    Author findByName(String name);
    Author findByID(String id);
    List<Author> findByBiography(String keyword);
}

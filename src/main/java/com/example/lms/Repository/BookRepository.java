package com.example.lms.Repository;

import com.example.lms.Model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Books, String> {
    
}

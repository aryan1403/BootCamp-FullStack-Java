package com.example.lms.Repository;

import com.example.lms.Model.Authors;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Authors, String> {
}

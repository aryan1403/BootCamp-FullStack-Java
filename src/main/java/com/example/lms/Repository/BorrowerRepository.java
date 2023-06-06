package com.example.lms.Repository;

import com.example.lms.Model.Borrowers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowerRepository extends MongoRepository<Borrowers, Integer> {
}

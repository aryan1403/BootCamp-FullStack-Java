package com.example.lms.Repository;

import com.example.lms.Model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
    // Additional methods for querying or manipulating transactions can be defined here
}

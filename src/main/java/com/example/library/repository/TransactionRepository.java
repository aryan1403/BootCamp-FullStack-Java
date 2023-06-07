package com.example.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Transaction;
public interface TransactionRepository extends MongoRepository<Transaction, String>  {
    /* Transaction findByBorrowerId(String borrowerId);
    
    Transaction findByBookId(String bookId);
    
    List<Transaction> findByDate(String Date); */

    
}

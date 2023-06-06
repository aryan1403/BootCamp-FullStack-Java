package com.example.library.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.library.model.Borrower;
@Repository
public interface BorrowerRepository extends MongoRepository<Borrower, String>{
    Borrower findByName(String name);
    List<Borrower> findByContactInformation (String Keyword);
    Borrower findByID(String id);
}

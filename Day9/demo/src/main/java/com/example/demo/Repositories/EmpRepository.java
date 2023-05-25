package com.example.demo.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Models.EmpModel;

public interface EmpRepository extends MongoRepository<EmpModel, String> {
    
}

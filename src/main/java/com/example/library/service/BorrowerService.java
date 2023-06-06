package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Borrower;
import com.example.library.repository.BorrowerRepository;

@Service
public class BorrowerService {
    @Autowired
    private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Optional<Borrower> getBorrowerById(String id) {
        return borrowerRepository.findById(id);
    }

    public Borrower addBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public void updateBorrower(Borrower borrower) {
        borrowerRepository.save(borrower);
    }

    public void deleteBorrower(String id) {
        borrowerRepository.deleteById(id);
    }

    public Borrower searchBorrowers(String name) {
        return borrowerRepository.findByName(name);
    }
}
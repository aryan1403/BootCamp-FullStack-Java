package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Transaction;
import com.example.library.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }
    
    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(String id) {
        transactionRepository.deleteById(id);
    }
}


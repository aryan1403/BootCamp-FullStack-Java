package com.example.lms.Service;

import com.example.lms.Model.Transaction;
import com.example.lms.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(String id, Transaction updatedTransaction) {
        Optional<Transaction> existingTransaction = transactionRepository.findById(id);
        if (existingTransaction.isPresent()) {
            updatedTransaction.setId(id);
            return transactionRepository.save(updatedTransaction);
        } else {
            throw new IllegalArgumentException("Transaction not found with id: " + id);
        }
    }

    public void deleteTransaction(String id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isPresent()) {
            transactionRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Transaction not found with id: " + id);
        }
    }
}

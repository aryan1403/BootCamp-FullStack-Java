package com.example.lms.Service;

import com.example.lms.Model.Borrowers;
import com.example.lms.Repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Autowired
    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrowers> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    public Optional<Borrowers> getBorrowerById(int id) {
        return borrowerRepository.findById(id);
    }

    public Borrowers createBorrower(Borrowers borrower) {
        return borrowerRepository.save(borrower);
    }

    public String updateBorrower(int id, Borrowers borrower) {
        Optional<Borrowers> existingBorrowerOptional = borrowerRepository.findById(id);
        if (existingBorrowerOptional.isPresent()) {
            Borrowers existingBorrower = existingBorrowerOptional.get();
            existingBorrower.setName(borrower.getName());
            existingBorrower.setPhoneNum(borrower.getPhoneNum());
            borrowerRepository.save(existingBorrower);
            return "Borrower updated successfully.";
        }
        return "Borrower not found.";
    }

    public String deleteBorrower(int id) {
        Optional<Borrowers> borrowerOptional = borrowerRepository.findById(id);
        if (borrowerOptional.isPresent()) {
            borrowerRepository.deleteById(id);
            return "Borrower deleted successfully.";
        }
        return "Borrower not found.";
    }
}

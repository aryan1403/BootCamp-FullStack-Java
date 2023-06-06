package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Borrower;
import com.example.library.service.BorrowerService;

@RestController
@RequestMapping("/borrowers")
    public class BorrowerController {
        @Autowired
        private final BorrowerService borrowerService;
    
        
        public BorrowerController(BorrowerService borrowerService) {
            this.borrowerService = borrowerService;
        }
    
        @GetMapping
        public List<Borrower> getAllBorrowers() {
            return borrowerService.getAllBorrowers();
        }
    
        @PostMapping
        public Borrower addBorrower(@RequestBody Borrower borrower) {
            return borrowerService.addBorrower(borrower);
        }
    
        @PutMapping("/{id}")
        public void updateBorrower(@PathVariable String id, @RequestBody Borrower borrower) {
            borrower.setId(id);
            borrowerService.updateBorrower(borrower);
        }
    
        @DeleteMapping("/{id}")
        public void deleteBorrower(@PathVariable String id) {
            borrowerService.deleteBorrower(id);
        }
    
        @GetMapping("/search")
        public Borrower searchBorrowers(@RequestParam String keyword) {
            return borrowerService.searchBorrowers(keyword);
        }
    }
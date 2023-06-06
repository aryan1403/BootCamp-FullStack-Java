package com.example.lms.Controller;

import com.example.lms.Model.Borrowers;
import com.example.lms.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

    private final BorrowerService borrowerService;

    @Autowired
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    @GetMapping
    public ResponseEntity<List<Borrowers>> getAllBorrowers() {
        List<Borrowers> borrowers = borrowerService.getAllBorrowers();
        return ResponseEntity.ok(borrowers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowers> getBorrowerById(@PathVariable int id) {
        Optional<Borrowers> borrowerOptional = borrowerService.getBorrowerById(id);
        return borrowerOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Borrowers> createBorrower(@RequestBody Borrowers borrower) {
        Borrowers createdBorrower = borrowerService.createBorrower(borrower);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBorrower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBorrower(@PathVariable int id, @RequestBody Borrowers borrower) {
        String result = borrowerService.updateBorrower(id, borrower);
        if (result.equals("Borrower updated successfully.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBorrower(@PathVariable int id) {
        String result = borrowerService.deleteBorrower(id);
        if (result.equals("Borrower deleted successfully.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

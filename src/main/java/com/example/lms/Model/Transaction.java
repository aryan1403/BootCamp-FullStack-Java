package com.example.lms.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Transaction {
    private String id;
    private Borrowers borrower;
    private Books book;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date borrowingDate;

    public Transaction() {
    }

    public Transaction(Borrowers borrower, Books book, Date borrowingDate) {
        this.borrower = borrower;
        this.book = book;
        this.borrowingDate = borrowingDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Borrowers getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrowers borrower) {
        this.borrower = borrower;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}

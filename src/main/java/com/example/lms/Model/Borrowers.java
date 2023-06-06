package com.example.lms.Model;

import org.springframework.data.annotation.Id;

public class Borrowers {
    @Id
    private int id;
    private String name;
    private long phoneNum;
    

    public Borrowers() {
    }

    public Borrowers(String name, long phoneNum, int id) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

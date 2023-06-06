package com.example.library.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Borrower {
    @Id
    private String id;
    private String name;
    private String contactInformation;
    
    public Borrower(String id, String name, String contactInformation) {
        this.id = id;
        this.name = name;
        this.contactInformation = contactInformation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    
}

package com.example.lms.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "authors")
public class Authors {
    @Id
    private String id;
    private String authorName;
    private String bio;

    public Authors() {
    }

    public Authors(String id, String authorName, String bio) {
        this.id = id;
        this.authorName = authorName;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "emp")
public class EmpModel {
    @Id
    String _id;
    String name;
    String role;
    double salary;
    double exp;
}

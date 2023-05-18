package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EmpModel {
    @Id
    String id;
    String name;
    String role;
    double salary;
    double exp;
}

package com.example.demo.Controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.EmpModel;

@RestController
public class demoController {
    @GetMapping("/")
    public String start() {
        return "Application Started";
    }

    @PostMapping("/save")
    public String saveData() {
        // save data into db
        return "Saved data to the database";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to my Site";
    }

    @PostMapping("/addEmp")
    public Object AddEmp(@RequestBody EmpModel eModel) {
        EmpModel model = new EmpModel(UUID.randomUUID().toString() ,eModel.getName(), eModel.getRole(), eModel.getSalary(), eModel.getExp());
        return "Added Emp Successfully";
    }
}

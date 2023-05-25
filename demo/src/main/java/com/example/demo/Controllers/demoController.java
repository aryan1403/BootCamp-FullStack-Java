package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Models.DataModel;
import com.example.demo.Models.EmpModel;
import com.example.demo.Repositories.EmpRepository;

@CrossOrigin
@RestController
public class demoController {

    @Autowired
    EmpRepository eRepo;

    @GetMapping("/")
    public String start() {
        return "Application Started";
    }

    @PostMapping("/save")
    public String saveData() {
        // save data into db
        return "Saved data to the database";
    }

    @PostMapping("/addEmp")
    public DataModel AddEmp(@RequestBody EmpModel eModel) {
        eModel = eRepo.save(eModel);
        return new DataModel(200, "Employee Added Successfully", eModel);
    }

    @GetMapping("/getEmp")
    public DataModel GetAllEmp() {
        return new DataModel(200, "Employee Fetched Successfully", eRepo.findAll());
    }

    @DeleteMapping("/delEmp")
    public DataModel DeleteEmp(@RequestBody EmpModel model) {
        eRepo.delete(model);
        return null;
    }

    @PostMapping("/editEmp" )
    public DataModel UpdateEmp(@RequestBody EmpModel model) {
        eRepo.save(model); 
        return null;
    }
}

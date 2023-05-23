package com.example.demo.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Models.EmpModel;

@RestController
public class demoController {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public demoController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

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
    public EmpModel addEmp(@RequestBody EmpModel eModel) {
        eModel.setId(UUID.randomUUID().toString());
        mongoTemplate.save(eModel);
        return eModel;
    }

    @GetMapping("/getEmp/{id}")
    public EmpModel getEmp(@PathVariable String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, EmpModel.class);
    }

    @GetMapping("/getAllEmp")
    public List<EmpModel> getAllEmp() {
        return mongoTemplate.findAll(EmpModel.class);
    }

    @PutMapping("/updateEmp/{id}")
    public EmpModel updateEmp(@PathVariable String id, @RequestBody EmpModel eModel) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("name", eModel.getName())
                .set("role", eModel.getRole())
                .set("salary", eModel.getSalary())
                .set("exp", eModel.getExp());
        mongoTemplate.updateFirst(query, update, EmpModel.class);
        return eModel;
    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, EmpModel.class);
        return "Deleted employee with ID: " + id;
    }
}

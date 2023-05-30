package com.example.backend.controller;

import com.example.backend.model.Item;
import com.example.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @PostMapping("/addItems")
    public Item addItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

}

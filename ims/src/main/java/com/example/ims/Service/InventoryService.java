package com.example.ims.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ims.Model.Item;
import com.example.ims.Repository.InventoryRepository;

@Service
public class InventoryService {
    private InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getItemById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void addItem(Item item) {
        repository.save(item);
    }

    public void updateItem(Item item) {
        repository.save(item);
    }

    public void deleteItem(String id) {
        repository.deleteById(id);
    }
}
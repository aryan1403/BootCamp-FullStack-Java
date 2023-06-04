package com.example.ims.Service;

import java.util.List;
import java.util.Random;

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

    public void updateItemAndDispatchQuantity(Item item, int dispatchQuantity) {
        // Update the item's quantity and dispatch quantity
        int updatedQuantity = item.getQuantity() - dispatchQuantity;
        item.setQuantity(updatedQuantity);
        item.setDispatchQuantity(dispatchQuantity);

        // Generate a random order number
        String orderNumber = generateOrderNumber();
        item.setOrderNumber(orderNumber);

        // Calculate SaleGenerated based on quantity times price
        double saleGenerated = item.getPrice() * dispatchQuantity;
        item.setSaleGenerated(saleGenerated);

        // Save the updated item to the database
        repository.save(item);
    }

    private String generateOrderNumber() {
        Random random = new Random();
        int orderNumber = random.nextInt(9000) + 1000; // Generate a 4-digit random number
        return "ORD" + orderNumber;
    }
}

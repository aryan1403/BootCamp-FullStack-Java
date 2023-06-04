package com.example.ims.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ims.Model.Item;
import com.example.ims.Service.InventoryService;
import com.example.ims.Model.DispatchRequest;

@CrossOrigin
@RestController
public class InventoryController {
    private InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable String id) {
        return service.getItemById(id);
    }

    @PostMapping("/item")
    public void addItem(@RequestBody Item item) {
        service.addItem(item);
    }

    @PutMapping("/items/{id}")
    public void updateItem(@PathVariable String id, @RequestBody Item item) {
        item.setId(id);
        service.updateItem(item);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable String id) {
        service.deleteItem(id);
    }

    @PutMapping("/items/{id}/dispatch")
    public void dispatchItem(@PathVariable String id, @RequestBody DispatchRequest request) {
        Item item = service.getItemById(id);
        int dispatchQuantity = request.getDispatchQuantity();

        // Update the item's quantity and dispatch quantity in the database
        service.updateItemAndDispatchQuantity(item, dispatchQuantity);
    }
}

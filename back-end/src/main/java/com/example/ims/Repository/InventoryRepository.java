package com.example.ims.Repository;

import com.example.ims.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Item, String> {
    
}

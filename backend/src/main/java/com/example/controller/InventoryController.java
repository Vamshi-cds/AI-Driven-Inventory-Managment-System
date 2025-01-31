package com.example.controller;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Inventory;
import com.example.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map; // Add this import

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: " + id));
        return ResponseEntity.ok(inventory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryDetails) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: " + id));

        inventory.setCurrentStock(inventoryDetails.getCurrentStock());
        inventory.setMinStockLevel(inventoryDetails.getMinStockLevel());

        Inventory updatedInventory = inventoryRepository.save(inventory);
        return ResponseEntity.ok(updatedInventory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteInventory(@PathVariable Long id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with id: " + id));

        inventoryRepository.delete(inventory);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
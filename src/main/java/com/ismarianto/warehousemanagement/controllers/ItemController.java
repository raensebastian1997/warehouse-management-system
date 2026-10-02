package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import com.ismarianto.warehousemanagement.models.Item;
import com.ismarianto.warehousemanagement.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")

public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<?> getAllItems() {
        try {
            List<Item> items = itemService.getAllItems();
            return new ResponseEntity<>(
                    new GlobalResponse<>(items, "Items retrieved", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Items retrieval failed", HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> getItemById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Item> item = itemService.getItemById(id);
             return new ResponseEntity<>(
                    new GlobalResponse<>(item, "Item found", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK
            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Item not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createItem(@RequestBody Item item) {
        try {

            Item createdItem = itemService.createItem(item);
            return new ResponseEntity<>(
                    new GlobalResponse<Item>(createdItem, "Item created", HttpStatus.CREATED, LocalDateTime.now()), HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Item creation failed", HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(value = "id") Long id, @RequestBody Item itemDetails) {
        try {
            Item updatedItem = itemService.updateItem(id, itemDetails);
            return new ResponseEntity<>(
                    new GlobalResponse<Item>(updatedItem, "Item updated", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK
            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Item not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable(value = "id") Long id) {
        try {
            itemService.deleteItem(id);
            return new ResponseEntity<>(
                    new GlobalResponse<>(null, "Item deleted", HttpStatus.NO_CONTENT, LocalDateTime.now()), HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(
                    new GlobalResponse<>(null, "Item not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }
}
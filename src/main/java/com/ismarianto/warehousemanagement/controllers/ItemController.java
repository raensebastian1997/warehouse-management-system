package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import com.ismarianto.warehousemanagement.models.Item;
import com.ismarianto.warehousemanagement.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController extends BaseController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Item>>> getAllItems() {
        try {
            List<Item> items = itemService.getAllItems();
            return createResponse(
                    new GlobalResponse<>(items, "Items retrieved", HttpStatus.OK)
            );
        } catch (Exception e) {
            return createResponse(new GlobalResponse<>(null, "Items retrieval failed", HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<GlobalResponse<Optional<Item>>> getItemById(@PathVariable(value = "id") Long id) {
        try {
            Optional<Item> item = itemService.getItemById(id);
             return createResponse(
                    new GlobalResponse<>(item, "Item found", HttpStatus.OK)
            );
        } catch (RuntimeException e) {
            return createResponse(new GlobalResponse<>(null, "Item not found", HttpStatus.NOT_FOUND));

        }
    }

    @PostMapping("/create")
    public ResponseEntity<GlobalResponse<Item>> createItem(@RequestBody Item item) {
        try {

            Item createdItem = itemService.createItem(item);
            return createResponse(
                    new GlobalResponse<Item>(createdItem, "Item created", HttpStatus.CREATED)
            );
        } catch (Exception e) {
            return createResponse(new GlobalResponse<>(null, "Item creation failed", HttpStatus.BAD_REQUEST));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GlobalResponse<Item>> updateItem(@PathVariable(value = "id") Long id, @RequestBody Item itemDetails) {
        try {
            Item updatedItem = itemService.updateItem(id, itemDetails);
            return createResponse(
                    new GlobalResponse<Item>(updatedItem, "Item updated", HttpStatus.OK)
            );
        } catch (RuntimeException e) {
            return createResponse(new GlobalResponse<>(null, "Item not found", HttpStatus.NOT_FOUND));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GlobalResponse<Object>> deleteItem(@PathVariable(value = "id") Long id) {
        try {
            itemService.deleteItem(id);
            return createResponse(
                    new GlobalResponse<>(null, "Item deleted", HttpStatus.NO_CONTENT));
        } catch (RuntimeException e) {
            return createResponse(
                    new GlobalResponse<>(null, "Item not found", HttpStatus.NOT_FOUND));
        }
    }
}
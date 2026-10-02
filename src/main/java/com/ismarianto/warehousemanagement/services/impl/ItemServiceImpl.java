package com.ismarianto.warehousemanagement.services.impl;

import com.ismarianto.warehousemanagement.models.Item;
import com.ismarianto.warehousemanagement.repository.ItemRepository;
import com.ismarianto.warehousemanagement.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {

        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item itemDetails) {
        try {
            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new com.ismarianto.warehousemanagement.exception.ResourceNotFoundException("Item not found with id: " + id));
            item.setName(itemDetails.getName());
            item.setVariants(itemDetails.getVariants());
            return itemRepository.save(item);
        } catch (Exception e) {
            throw new RuntimeException("Error updating item: " + e.getMessage());
        }
    }

    @Override
    public void deleteItem(Long id) {
        try {
            Item item = itemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
            itemRepository.delete(item);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting item: " + e.getMessage());
        }
    }
}
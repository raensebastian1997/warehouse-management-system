package com.ismarianto.warehousemanagement.services;

import com.ismarianto.warehousemanagement.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> getAllItems();

    Optional<Item> getItemById(Long id);

    Item createItem(Item item);

    Item updateItem(Long id, Item itemDetails);

    void deleteItem(Long id);
}
package com.ismarianto.warehousemanagement.repository;

import com.ismarianto.warehousemanagement.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i LEFT JOIN FETCH i.variants")
    List<Item> findAllWithVariants();
}
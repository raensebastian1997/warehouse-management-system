package com.ismarianto.warehousemanagement.repository;

import com.ismarianto.warehousemanagement.models.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long> {
}
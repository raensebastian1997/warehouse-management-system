package com.ismarianto.warehousemanagement.services;

import com.ismarianto.warehousemanagement.models.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {
    List<Variant> getAllVariants();
    Optional<Variant> getVariantById(Long id);
    Variant createVariant(Variant variant);
    Variant updateVariant(Long id, Variant variantDetails);
    void deleteVariant(Long id);
    void sellVariant(Long id, int quantity);
}
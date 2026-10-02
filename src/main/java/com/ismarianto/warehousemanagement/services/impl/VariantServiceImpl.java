package com.ismarianto.warehousemanagement.services.impl;

import com.ismarianto.warehousemanagement.models.Variant;
import com.ismarianto.warehousemanagement.repository.VariantRepository;
import com.ismarianto.warehousemanagement.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    @Override
    public Optional<Variant> getVariantById(Long id) {
        return variantRepository.findById(id);
    }

    @Override
    public Variant createVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public Variant updateVariant(Long id, Variant variantDetails) {
        try {
            Variant variant = variantRepository.findById(id)
                    .orElseThrow(() -> new com.ismarianto.warehousemanagement.exception.ResourceNotFoundException("Variant not found with id: " + id));
            variant.setName(variantDetails.getName());
            variant.setPrice(variantDetails.getPrice());
            variant.setStock(variantDetails.getStock());
            return variantRepository.save(variant);
        } catch (Exception e) {
            throw new RuntimeException("Error updating variant: " + e.getMessage());
        }
    }

    @Override
    public void deleteVariant(Long id) {
        try {
            Variant variant = variantRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Variant not found with id: " + id));
            variantRepository.delete(variant);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting variant: " + e.getMessage());
        }
    }

    @Override
    public void sellVariant(Long id, int quantity) {
        try {
            Variant variant = variantRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Variant not found with id: " + id));
            if (variant.getStock() < quantity) {
                throw new RuntimeException("Not enough stock for this variant");
            }
            variant.setStock(variant.getStock() - quantity);
            variantRepository.save(variant);
        } catch (Exception e) {
            throw new RuntimeException("Error selling variant: " + e.getMessage());
        }
    }
}
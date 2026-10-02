package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import com.ismarianto.warehousemanagement.models.Variant;
import com.ismarianto.warehousemanagement.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/variants")
public class VariantController {

    @Autowired
    private VariantService variantService;

    @GetMapping
    public ResponseEntity<?> getAllVariants() {
        try {
            List<Variant> variants = variantService.getAllVariants();
            return new ResponseEntity<>(new GlobalResponse<>(variants, "Variants retrieved", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variants retrieval failed", HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVariantById(
            @PathVariable(value = "id") Long id
    ) {
        try {
            Variant variant = variantService.getVariantById(id).orElseThrow(() -> new RuntimeException("Variant not found"));
            return new ResponseEntity<>(new GlobalResponse<>(variant, "Variant found", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createVariant(@RequestBody Variant variant) {
        try {

            variantService.createVariant(variant);
            return new ResponseEntity<>(new GlobalResponse<>(variant, "Variant created", HttpStatus.CREATED, LocalDateTime.now()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant creation failed", HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVariant(
            @PathVariable(value = "id") Long id,
            @RequestBody Variant
            variantDetails
    ) {
        try {
            Variant updatedVariant = variantService.updateVariant(id, variantDetails);
            return new ResponseEntity<>(new GlobalResponse<>(updatedVariant, "Variant updated", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVariant(@PathVariable(value = "id") Long id) {
        try {
            variantService.deleteVariant(id);
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant deleted", HttpStatus.NO_CONTENT, LocalDateTime.now()), HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/sell")
    public ResponseEntity<?> sellVariant(@PathVariable(value = "id") Long id, @RequestParam int quantity) {
        try {
            variantService.sellVariant(id, quantity);
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant sold", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
        }
    }
}
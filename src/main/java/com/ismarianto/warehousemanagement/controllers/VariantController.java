package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import com.ismarianto.warehousemanagement.models.Variant;
import com.ismarianto.warehousemanagement.services.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/variants")
public class VariantController extends BaseController {

    @Autowired
    private VariantService variantService;

    @GetMapping
    public ResponseEntity<GlobalResponse<List<Variant>>> getAllVariants() {
        try {
            List<Variant> variants = variantService.getAllVariants();
            return createResponse(new GlobalResponse<>(variants, "Variants retrieved", HttpStatus.OK));
        } catch (Exception e) {
            return createResponse(new GlobalResponse<>(null, "Variants retrieval failed", HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalResponse<Variant>> getVariantById(
            @PathVariable(value = "id") Long id
    ) {
        try {
            Variant variant = variantService.getVariantById(id).orElseThrow(() -> new RuntimeException("Variant not found"));
            return createResponse(new GlobalResponse<>(variant, "Variant found", HttpStatus.OK));
        } catch (RuntimeException e) {
            return createResponse(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND));
        }
    }

    @PostMapping
    public ResponseEntity<GlobalResponse<Variant>> createVariant(@RequestBody Variant variant) {
        try {

            variantService.createVariant(variant);
            return createResponse(new GlobalResponse<>(variant, "Variant created", HttpStatus.CREATED));
        } catch (Exception e) {
            return createResponse(new GlobalResponse<>(null, "Variant creation failed", HttpStatus.BAD_REQUEST));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalResponse<Variant>> updateVariant(
            @PathVariable(value = "id") Long id,
            @RequestBody Variant
            variantDetails
    ) {
        try {
            Variant updatedVariant = variantService.updateVariant(id, variantDetails);
            return createResponse(new GlobalResponse<>(updatedVariant, "Variant updated", HttpStatus.OK));
        } catch (RuntimeException e) {
            return createResponse(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalResponse<Object>> deleteVariant(@PathVariable(value = "id") Long id) {
        try {
            variantService.deleteVariant(id);
            return createResponse(new GlobalResponse<>(null, "Variant deleted", HttpStatus.NO_CONTENT));
        } catch (RuntimeException e) {
            return createResponse(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND));
        }
    }

    @PostMapping("/{id}/sell")
    public ResponseEntity<GlobalResponse<Object>> sellVariant(@PathVariable(value = "id") Long id, @RequestParam int quantity) {
        try {
            variantService.sellVariant(id, quantity);
            return createResponse(new GlobalResponse<>(null, "Variant sold", HttpStatus.OK));
        } catch (RuntimeException e) {
            return createResponse(new GlobalResponse<>(null, "Variant not found", HttpStatus.NOT_FOUND));
        }
    }
}
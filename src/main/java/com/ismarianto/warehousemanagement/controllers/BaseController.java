package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    protected <T> ResponseEntity<GlobalResponse<T>> createResponse(GlobalResponse<T> response) {
        return new ResponseEntity<>(response, response.getStatus());
    }
}
package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController extends BaseController {

    @GetMapping()
    public ResponseEntity<GlobalResponse<Object>> index() {
        return createResponse(new GlobalResponse<>(null, "Rest V1", HttpStatus.OK));
    }
}
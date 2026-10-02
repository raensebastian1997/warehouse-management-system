package com.ismarianto.warehousemanagement.controllers;

import com.ismarianto.warehousemanagement.dto.GlobalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/")
public class BaseController {

    @GetMapping()
    public ResponseEntity<?> index() {
        return new ResponseEntity<>(new GlobalResponse<>(null, "Rest V1", HttpStatus.OK, LocalDateTime.now()), HttpStatus.OK);
    }

}

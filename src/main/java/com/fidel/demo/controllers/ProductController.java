package com.fidel.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.fidel.demo.services.IProductService;

@RestController
public class ProductController {

    @Autowired
    final private IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<?> GetAll() {
        return ResponseEntity.ok(this.service.findAll());
    }
}

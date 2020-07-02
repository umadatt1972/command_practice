package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Product;
import com.example.demo.service.ProductService;
 
@RestController
@RequestMapping("/api")
public class ProductController {
 
    @Autowired
    private ProductService service;
     
    @GetMapping("/products")
    public List<Product> list() {
        return service.listAll();
    }
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable   Integer id) {
        return service.get(id);
    }
}


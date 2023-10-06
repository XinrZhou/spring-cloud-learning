package com.example.products.controller;

import com.example.common.pojo.Products;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("product/{id}")
    public Products getProduct(@PathVariable  Integer id) {
        return productService.findById(id);
    }
}

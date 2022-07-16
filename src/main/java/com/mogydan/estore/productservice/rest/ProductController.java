package com.mogydan.estore.productservice.rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public String createProduct() {
        return "HTTP Post is handled";
    }

    @GetMapping
    public String getProduct() {
        return "HTTP Get is handled";
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP Put is handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP Delete is handled";
    }
}

package com.capitanbeto.sushi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/combos")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }
}

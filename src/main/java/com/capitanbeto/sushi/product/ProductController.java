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
    public List<Product> getProducts(@RequestParam(required = false) Integer limit) {
        if (limit == null) {
            return productService.getProducts();
        }
        return productService.getProducts().subList(0, limit);
    }

    @GetMapping(path = "{productId}")
    public ResponseEntity<Object> getSingleProduct(@PathVariable("productId") Long id) {
        return this.productService.getSingleProducts(id);
    }

    @GetMapping(path = "/categories")
    public List<String> getCategories() {
        return this.productService.categoriesList();
    }

    @PostMapping
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> delete(@PathVariable("productId") Long id) {
        return this.productService.deleteProduct(id);
    }
}

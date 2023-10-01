package com.capitanbeto.sushi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", ""})
    public List<Product> getProducts(@RequestParam(required = false) Integer limit) {
        if (limit == null) {
            return productService.getProducts();
        }
        return productService.getProducts().subList(0, limit);
    }

    @GetMapping({"{productId}", "{productId}/"})
    public ResponseEntity<Object> getSingleProduct(@PathVariable("productId") Long id) {
        return this.productService.getSingleProducts(id);
    }

    @GetMapping({"/categories", "categories/"})
    public List<String> getCategories() {
        return this.productService.categoriesList();
    }

    @GetMapping({"/categories/{category}", "/categories/{category}/"})
    public List<Product> getByCategory(@PathVariable("category") String cat, @RequestParam(required = false) Integer limit) {
        if (limit == null) {
            return this.productService.listByCategory(cat);
        }
        return this.productService.listByCategory(cat).subList(0, limit);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @PutMapping({"/", ""})
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return this.productService.newProduct(product);
    }

    @DeleteMapping({"{productId}", "{productId}/"})
    public ResponseEntity<Object> delete(@PathVariable("productId") Long id) {
        return this.productService.deleteProduct(id);
    }
}

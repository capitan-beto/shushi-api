package com.capitanbeto.sushi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> newProduct(Product product) {
        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();

        if (res.isPresent()) {
            data.put("error", true);
            data.put("message", "There's already a product with that name");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }
        productRepository.save(product);
        data.put("data", product);
        data.put("message", "Product successfully saved");
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }
}

package com.capitanbeto.sushi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return List.of(
                new Product(
                        1,
                        "Futurama",
                        500,
                        "Roll",
                        "Roll de pollo",
                        "imagen.com"
                )
        );
    }
}

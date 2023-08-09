package com.capitanbeto.sushi.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts() {
        return List.of(
                new Product(
                        1,
                        "Poshi",
                        500,
                        "Roll",
                        "Roll de pollo",
                        "imagen.com"
                )
        );
    }
}

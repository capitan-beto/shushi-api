package com.capitanbeto.sushi.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    @GetMapping
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

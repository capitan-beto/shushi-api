package com.capitanbeto.sushi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    HashMap<String, Object> data;

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }

    public ResponseEntity<Object> getSingleProducts(Long id) {
        data = new HashMap<>();
        Optional<Product> res = this.productRepository.findById(id);
        if (res.isEmpty()) {
            data.put("error", true);
            data.put("message", "Product ID not found");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.NOT_FOUND
            );
        }

        data.put("message", res);
        return new ResponseEntity<>(
                data,
                HttpStatus.OK
        );
    }

    public ResponseEntity<Object> newProduct(Product product) {
        data = new HashMap<>();
        Optional<Product> res = productRepository.findProductByName(product.getName());

        if (res.isPresent() && product.getId() == null) {
            data.put("error", true);
            data.put("message", "There's already a product with that name");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

        data.put("message", "Product successfully saved");
        if (product.getId() != null) {
            data.put("message", "Product successfully updated");
        }

        productRepository.save(product);
        data.put("data", product);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteProduct(Long id) {
        data = new HashMap<>();
        boolean exists = this.productRepository.existsById(id);

        if (!exists) {
            data.put("error", true);
            data.put("message", "There's no product with that ID");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.NOT_FOUND
            );
        }

        productRepository.deleteById(id);
        data.put("message", "Product successfully deleted");
        return new ResponseEntity<>(
                data,
                HttpStatus.ACCEPTED
        );
    }

    public List<String> categoriesList() {
        List<Product> combos = this.getProducts();
        List<String> categories = new ArrayList<>();
        for (int i = 0; i < combos.size(); i++) {
            if ( !categories.contains(combos.get(i).getCategory()) ) {
                categories.add( combos.get(i).getCategory() );
            }
        }
        return categories;
    }
}

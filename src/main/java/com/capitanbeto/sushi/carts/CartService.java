package com.capitanbeto.sushi.carts;

import com.capitanbeto.sushi.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    HashMap<String, Object> data;

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCarts() {
       return this.cartRepository.findAll();
    }

    public ResponseEntity<Object> getSingleCart(Long id) {
        data = new HashMap<>();
        Optional<Cart> res = this.cartRepository.findById(id);
        if (res.isEmpty()) {
            data.put("error", true);
            data.put("message", "Cart ID not found");
            return new ResponseEntity<> (
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
}

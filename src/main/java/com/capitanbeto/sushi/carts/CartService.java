package com.capitanbeto.sushi.carts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CartService {

    HashMap<String, Object> data;

    private final CartRepository cartRepository;

    private final CartProductRepository cartProductRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CartProductRepository cartProductRepository) {
        this.cartRepository = cartRepository;
        this.cartProductRepository = cartProductRepository;
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

    public ResponseEntity<Object> getUserCart(Long id) {
        data = new HashMap<>();
        Optional<Cart> res = this.cartRepository.findCartByUserId(id);

        if (res.isEmpty()) {
            data.put("error", true);
            data.put("message", "User ID not found");
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

    public ResponseEntity<Object> newCart(Cart cart) {
        data = new HashMap<>();
        Optional<Cart> res = cartRepository.findCartByUserId(cart.getUserId());

        if (res.isPresent() && cart.getCartId() == null) {
            data.put("error", true);
            data.put("message", "There's already a cart with that ID");
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

        data.put("message", "Cart successfully saved");
        if (cart.getCartId() != null) {
            data.put("message", "Cart successfully updated");
        }

        Set<CartProduct> products = cart.getProducts();
        cartRepository.save(cart);
        for (CartProduct product : products) {
            product.setCart(cart);
            cartProductRepository.save(product);
        }
        data.put("data", cart);
        return new ResponseEntity<>(
                data,
                HttpStatus.CREATED
        );
    }
}
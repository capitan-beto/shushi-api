package com.capitanbeto.sushi.carts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping({"", "/"})
    public List<Cart> getCarts(@RequestParam(required = false) Integer limit) {
        if (limit == null) {
            return cartService.getCarts();
        }
        return cartService.getCarts().subList(0, limit);
    }

    @GetMapping({"{cartId}", "{cartId}/"})
    public ResponseEntity<Object> getSingleCart(@PathVariable("cartId") Long id) {
        return this.cartService.getSingleCart(id);
    }

    @GetMapping({"/user/{userId}", "/user/{userId}/"})
    public ResponseEntity<Object> getUserCart(@PathVariable("userId") Long id) {
        return this.cartService.getUserCart(id);
    }
}

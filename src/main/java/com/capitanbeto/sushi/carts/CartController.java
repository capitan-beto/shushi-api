package com.capitanbeto.sushi.carts;

import com.capitanbeto.sushi.product.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Cart> getCarts() {
        return this.cartService.getCarts();
    }

    @GetMapping({"{cartId}", "{cartId}/"})
    public ResponseEntity<Object> getSingleCart(@PathVariable("cartId") Long id) {
        return this.cartService.getSingleCart(id);
    }


}

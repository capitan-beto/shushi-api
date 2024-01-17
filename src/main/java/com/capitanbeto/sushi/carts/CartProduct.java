package com.capitanbeto.sushi.carts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cart_products")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private int productId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    @JsonIgnore
    private Cart cart;

    public CartProduct() {
    }

    public CartProduct(Long id, int productId, int quantity, Cart cart) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}

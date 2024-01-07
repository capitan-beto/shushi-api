package com.capitanbeto.sushi.carts;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_products")
public class CartProduct {

    @Id
    private Long id;

    private int productId;

    private int quantity;

    public CartProduct() {
    }

    public CartProduct(Long id, int productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
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
}

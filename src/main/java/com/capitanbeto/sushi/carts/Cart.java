package com.capitanbeto.sushi.carts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    private int userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @OneToMany(mappedBy = "cart")
    private Set<CartProduct> products;

    public Cart() {
    }

    public Cart(int userId, Date date, Set<CartProduct> products) {
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

    public Cart(Long cartId, int userId, Date date, Set<CartProduct> products) {
        this.cartId = cartId;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<CartProduct> products) {
        this.products = products;
    }
}

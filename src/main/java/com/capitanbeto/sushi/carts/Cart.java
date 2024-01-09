package com.capitanbeto.sushi.carts;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int userId;

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

    public Cart(Long id, int userId, Date date, Set<CartProduct> products) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

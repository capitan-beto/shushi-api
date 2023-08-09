package com.capitanbeto.sushi.product;

public class Product {
    private Long id;

    private String name;

    private float price;

    private String category;

    private String description;

    private String image;

    public Product() {
    }

    public Product(Long id, String name, float price, String category, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
    }

    public Product(String name, float price, String category, String description, String image) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
    }
}

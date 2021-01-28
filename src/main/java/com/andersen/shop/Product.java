package com.andersen.shop;

import lombok.Data;

@Data
public class Product {
    private long id;
    private int price;
    private String name;
    private String description;

    public Product(int price, String description, String name) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product() {
    }

    void showInfo() {
        System.out.println(String.format("product id: %d\nproduct price: %s\nproduct description: %s\n", id, price, description));
    }
}

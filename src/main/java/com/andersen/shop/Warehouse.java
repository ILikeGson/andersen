package com.andersen.shop;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Product, Integer> productQuantity;

    public Warehouse() {
        init();
    }

    public void init() {
        productQuantity = new HashMap<>();
        Product cucumber = new Product(11, "cucumber-new", "cucumber", LocalDate.now(), LocalDate.of(2021, 1, 31));
        Product lemon = new Product(10, "lemon-new", "lemon", LocalDate.now(), LocalDate.of(2021, 2, 1));
        Product tomato = new Product(15, "tomato-new", "tomato", LocalDate.now(), LocalDate.of(2021, 2, 1));
        Product milk = new Milk(20, "milk-new", "milk", LocalDate.now(), LocalDate.of(2021, 2, 3));
        productQuantity.put(cucumber, 10);
        productQuantity.put(tomato, 10);
        productQuantity.put(lemon, 10);
        productQuantity.put(milk, 10);
    }

    public void addProduct(Product product) {
        new ExpiredAnalyzer().analyze(product);
        int quantity = productQuantity.getOrDefault(product, 0);
        productQuantity.put(product, quantity + 1);
    }
}

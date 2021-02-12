package com.andersen.shop.model;

import com.andersen.shop.ExpiredAnalyzer;
import lombok.Getter;

import java.io.Serializable;
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
    }

    public void addProduct(Product product) {
        new ExpiredAnalyzer().analyze(product);
        int quantity = productQuantity.getOrDefault(product, 0);
        productQuantity.put(product, quantity + 1);
    }
}

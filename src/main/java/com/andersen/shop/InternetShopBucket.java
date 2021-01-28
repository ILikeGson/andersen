package com.andersen.shop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InternetShopBucket implements Bucket{
    private List<Product> productBucket = new ArrayList<>();

    @Override
    public void showProducts() {
        productBucket.forEach(Product::showInfo);
    }

    @Override
    public void addProduct(Product product) {
        productBucket.add(product);
    }

    @Override
    public void removeById(int id) {
        productBucket.remove(id);
    }

    @Override
    public void clear() {
        productBucket.clear();
    }
}

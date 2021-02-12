package com.andersen.shop;

import com.andersen.shop.model.Product;

public interface Bucket {
    void showProducts();
    void addProduct(Product product);
    void removeById(int id);
    void clear();
    double price();
}

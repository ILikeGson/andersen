package com.andersen.shop;

public interface Bucket {
    void showProducts();
    void addProduct(Product product);
    void removeById(int id);
    void clear();
}

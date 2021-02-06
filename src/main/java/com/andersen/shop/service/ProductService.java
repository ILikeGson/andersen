package com.andersen.shop.service;

import com.andersen.shop.Product;

import java.util.List;

public interface ProductService {
    int add(Product product);
    Product getById(int id);
    List<Product> getAll();
    void deleteById(int id);
}

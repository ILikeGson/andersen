package com.andersen.shop.service;

import com.andersen.shop.model.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    Product getById(int id);
    List<Product> getAll();
    void deleteById(int id);
}

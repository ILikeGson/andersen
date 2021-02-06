package com.andersen.shop.dao;

import com.andersen.shop.Product;

import java.util.List;

public interface ProductDao {
    int add(Product product);
    Product getById(int id);
    List<Product> getAll();
    void deleteById(int id);
}

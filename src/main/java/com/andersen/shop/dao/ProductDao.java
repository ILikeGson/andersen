package com.andersen.shop.dao;

import com.andersen.shop.model.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);
    Product getById(int id);
    List<Product> getAll();
    void deleteById(int id);
}

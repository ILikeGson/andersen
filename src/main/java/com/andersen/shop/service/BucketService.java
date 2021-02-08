package com.andersen.shop.service;

import com.andersen.shop.Product;

import java.util.List;

public interface BucketService {
    void addProductToUserBucketById(int userId, int id);
    List<Product> getAll(int userId);
    void removeProductById(int userId, int id);
}

package com.andersen.shop.dao;

import com.andersen.shop.Product;
import java.util.List;

public interface BucketDao {
    void addProductToUserBucketById(int userId, int id);
    List<Product> getAll(int userId);
    void removeProductById(int userId, int id);
}

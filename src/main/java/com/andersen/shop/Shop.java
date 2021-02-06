package com.andersen.shop;

public interface Shop {
    void showAllProducts();
    void showProductsInBucket(int userId);
    void addProductToBucketById(int id, int userId);
    void removeFromBucketById(int id, int userId);
    void clear(int userId);
}

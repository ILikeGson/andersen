package com.andersen.shop;

public interface Shop {
    void showAllProducts();
    void showProductsInBucket();
    Product addToProducts(Product product);
    void addProductToBucketById(int id);
    void removeFromBucketById(int id);
    void clear();
}

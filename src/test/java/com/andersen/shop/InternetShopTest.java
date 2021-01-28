package com.andersen.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternetShopTest {
    private InternetShop shop = new InternetShop();

    @Test
    void showAllProducts() {
        assertEquals(shop.getProducts().size(), 3);
        shop.showAllProducts();
    }

    @Test
    void showProductsInTheBucket() {
        shop.addProductToBucketById(0);
        shop.showProductsInBucket();
    }


    @Test
    void addProductToBucket() {
        InternetShopBucket bucket = shop.getBucket();
        assertEquals(bucket.getProductBucket().size(), 0);
        shop.addProductToBucketById(0);
        shop.addProductToBucketById(1);
        shop.addProductToBucketById(2);
        assertEquals(bucket.getProductBucket().size(), 3);
    }

    @Test
    void removeFromBucket() {
        InternetShopBucket bucket = shop.getBucket();
        shop.addProductToBucketById(0);
        assertEquals(bucket.getProductBucket().size(), 1);
        bucket.removeById(0);
        assertEquals(bucket.getProductBucket().size(), 0);

    }

    @Test
    void clear() {
        InternetShopBucket bucket = shop.getBucket();
        shop.addProductToBucketById(0);
        shop.addProductToBucketById(1);
        shop.addProductToBucketById(2);
        assertEquals(bucket.getProductBucket().size(), 3);
        bucket.clear();
        assertEquals(bucket.getProductBucket().size(), 0);
    }
}
package com.andersen.shop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class InternetShop implements Shop{
    private List<Product> products;
    private InternetShopBucket bucket;

    public InternetShop() {
        this.products = new ArrayList<>();
        this.bucket = new InternetShopBucket();
        init();
    }

    private void init() {
        addToProducts(new Product(11, "cucumber-new", "cucumber"));
        //addToProducts(new Product(10, "lemon-new", "lemon"));
        //addToProducts(new Product(15, "tomato-new", "tomato"));
    }

    @Override
    public void showAllProducts() {
        products.forEach(Product::showInfo);
    }

    @Override
    public void showProductsInBucket() {
        bucket.showProducts();
    }

    @Override
    public Product addToProducts(Product product) {
        products.add(product);
        product.setId(products.size() - 1);
        return product;
    }

    @Override
    public void addProductToBucketById(int id) {
        if (id >= 0 && id < products.size()) {
            bucket.addProduct(products.get(id));
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public void removeFromBucketById(int id) {
        bucket.removeById(id);
    }

    @Override
    public void clear() {
        bucket.clear();
    }
}

package com.andersen.shop;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class InternetShopBucket implements Bucket, Serializable {
    private long id;
    private User user;
    private List<Product> productBucket;

    public InternetShopBucket(User user) {
        this.user = user;
        if (Objects.isNull(productBucket)) {
            productBucket = new ArrayList<>();
        }
    }

    @Override
    public void showProducts() {
        productBucket.forEach(Product::showInfo);
    }

    @Override
    public void addProduct(Product product) {
        productBucket.add(product);
    }

    @Override
    public void removeById(int id) {
        productBucket.remove(id);
    }

    public double price() {
        final double[] price = new double[1];
        if (user.getCurrency().getName().equalsIgnoreCase("UAH")) {
            productBucket.forEach(product -> price[0] = price[0] + (product.getPrice() * user.getCurrency().getCourse() * 1.2));
        } else {
            productBucket.forEach(product -> price[0] = price[0] + (product.getPrice() * user.getCurrency().getCourse() * 1.21));
        }
        return price[0];
    }

    @Override
    public void clear() {
        productBucket.clear();
    }
}

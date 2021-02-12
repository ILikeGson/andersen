package com.andersen.shop.model;

import com.andersen.shop.Bucket;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
@Table(name = "bucket")
public class InternetShopBucket implements Bucket, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bucketId;

    @OneToOne
    private User bucketOwner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_to_buckets", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "bucket_id"))
    private List<Product> productBucket;

    public InternetShopBucket(User user) {
        this.bucketOwner = user;
    }

    @Override
    public void showProducts() {
        productBucket.forEach(Product::showInfo);
    }

    @Override
    public void addProduct(Product product) {
        if (Objects.isNull(productBucket)) {
            productBucket = new ArrayList<>();
        }
        productBucket.add(product);
    }

    @Override
    public void removeById(int id) {
        ListIterator<Product> iterator = productBucket.listIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public List<Product> getProductBucket() {
        if (Objects.isNull(productBucket)) {
            productBucket = new ArrayList<>();
        }
        return productBucket;
    }

    public void setProductBucket(List<Product> productBucket) {
        this.productBucket = productBucket;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getBucketId() {
        return bucketId;
    }

    public User getBucketOwner() {
        return bucketOwner;
    }

    public double price() {
        final double[] price = new double[1];
        if (bucketOwner.getCurrency().getName().equals("UAH")) {
            productBucket.forEach(product -> price[0] = price[0] + (product.getPrice() * bucketOwner.getCurrency().getCourse() * 1.2));
        } else {
            productBucket.forEach(product -> price[0] = price[0] + (product.getPrice() * bucketOwner.getCurrency().getCourse() * 1.21));
        }
        return price[0];
    }

    @Override
    public void clear() {
        productBucket.clear();
    }
}


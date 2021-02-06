package com.andersen.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IsProductExpired
public class Product implements Serializable {
    private long id;
    private int price;
    private String name;
    private String description;
    private LocalDate createdDate;
    private LocalDate expiredDate;
    private boolean isExpired;

    public Product(int price, String name, String description, LocalDate created, LocalDate expiredDate) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.createdDate = created;
        this.expiredDate = expiredDate;
    }

    void showInfo() {
        System.out.println(String.format("product id: %d\nproduct price: %s\nproduct description: %s\nis product expired? %s", id, price, description, isExpired));
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", expiredDate=" + expiredDate +
                ", isExpired=" + isExpired +
                '}';
    }
}

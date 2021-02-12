package com.andersen.shop.model;

import com.andersen.shop.IsProductExpired;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IsProductExpired
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "creating_date")
    private LocalDate createdDate;

    @Column(name = "expiring_date")
    private LocalDate expiredDate;

    @Column(name = "is_expired")
    private boolean isExpired;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn (name = "country_id")
    private Country country;

    public Product(int price, String name, String description, LocalDate createdDate, LocalDate expiredDate, boolean isExpired, Country country) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.expiredDate = expiredDate;
        this.isExpired = isExpired;
        this.country = country;
    }

    public Product(int price, String name, String description, LocalDate createdDate, LocalDate expiredDate,Country country) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.expiredDate = expiredDate;
        this.country = country;
    }

    void showInfo() {
        System.out.println(String.format("product id: %d\nproduct price: %s\nproduct description: %s\nis product expired? %s", id, price, description, isExpired));
    }
}

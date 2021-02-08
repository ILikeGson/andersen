package com.andersen.shop;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String firstName;
    private String lastName;
    private Currency currency;
    private InternetShopBucket bucket;
    private List<Order> orders;

    public User (String firstName, String lastName, Currency currency) {
        bucket = new InternetShopBucket(this);
        this.firstName = firstName;
        this.lastName = lastName;
        this.currency = currency;
    }

    public Order makeOrder() {
        Order order = new Order();
        order.setId(orders.size() - 1);
        order.setUser(this);
        order.setProducts(bucket.getProductBucket());
        order.setWhenCreated(LocalDateTime.now());
        return order;
    }
}

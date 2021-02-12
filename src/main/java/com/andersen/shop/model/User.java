package com.andersen.shop.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String firstName;

    @Column(name = "user_surname")
    private String lastName;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @OneToOne(mappedBy = "bucketOwner")
    private InternetShopBucket bucket;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

    public User (String firstName, String lastName, Currency currency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.currency = currency;
    }

    public Order makeOrder() {
        Order order = new Order();
        order.setId(orders.size() - 1);
        order.setClient(this);
        order.setProducts(bucket.getProductBucket());
        order.setWhenCreated(LocalDateTime.now());
        return order;
    }

    public InternetShopBucket getBucket() {
        if (Objects.isNull(bucket)) {
            return new InternetShopBucket(this);
        }
        return bucket;
    }
}

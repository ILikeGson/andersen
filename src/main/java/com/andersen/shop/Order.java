package com.andersen.shop;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private long id;
    private boolean isProcessed;
    private LocalDateTime whenCreated;
    private List<Product> products;
    private User user;
}

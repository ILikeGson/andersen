package com.andersen.shop;

import java.time.LocalDate;

public class Milk extends Product {
    public Milk(int price, String description, String name, LocalDate created, LocalDate expired) {
        super(price, description, name, created, expired);
    }
}

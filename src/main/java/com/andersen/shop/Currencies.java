package com.andersen.shop;

public class Currencies {

    public static Currency uah() {
        return new Currency("001055", "UAH", 28.15, 1000000000);
    }

    public static Currency dollar() {
        return new Currency("ISO 4217", "DLR", 1, 1000000000);
    }
}

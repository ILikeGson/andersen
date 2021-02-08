package com.andersen.shop;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum Currency implements Serializable {
    UAH("001055", "UAH", 28.15, 1000000000), DLR("ISO 4217", "DLR", 1, 1000000000);

    static final long UUID = 1L;
    private final String internationalCode;
    private final String name;
    private final double course;
    private final int multiplicity;

    private Currency(String internationalCode, String name, double course, int multiplicity) {
        this.internationalCode = internationalCode;
        this.name = name;
        this.course = course;
        this.multiplicity = multiplicity;
    }
}

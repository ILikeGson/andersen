package com.andersen.shop;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class  Currency implements Serializable {
    private String internationalCode;
    private String name;
    private double course;
    private int multiplicity;

    public Currency(String internationalCode, String name, double course, int multiplicity) {
        this.internationalCode = internationalCode;
        this.name = name;
        this.course = course;
        this.multiplicity = multiplicity;
    }
}

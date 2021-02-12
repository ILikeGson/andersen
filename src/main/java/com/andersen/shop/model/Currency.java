package com.andersen.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "currencies")
public class Currency implements Serializable {
    static final long UUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "currency_id")
    private int id;

    @Column(name = "international_code")
    private String internationalCode;

    @Column(name = "currency_name")
    private String name;

    @Column(name = "course")
    private double course;

    @Column(name = "multiplicity")
    private int multiplicity;

    public Currency(String internationalCode, String name, double course, int multiplicity) {
        this.internationalCode = internationalCode;
        this.name = name;
        this.course = course;
        this.multiplicity = multiplicity;
    }

    public Currency() {
    }
}



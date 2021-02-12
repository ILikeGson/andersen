package com.andersen.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int id;

    @Column(name = "country_name")
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Product> products;

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country(String countryName) {
        this.name = countryName;
    }
}

package com.andersen.shop.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Things")
@DiscriminatorValue("Things")
public class Thing extends Product{
}

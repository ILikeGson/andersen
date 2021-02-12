package com.andersen.shop.model;

import javax.persistence.*;

@Entity(name = "Food")
@DiscriminatorValue("Food")
public class Food extends Product{
}

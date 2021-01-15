package com.andersen.patterns.creational.abstractfactory.product;

public class PrivateSchoolDirector implements Director{

    @Override
    public void manage() {
        System.out.println("Director: Manages staff very well");
    }
}

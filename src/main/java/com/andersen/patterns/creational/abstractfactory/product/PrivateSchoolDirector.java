package com.andersen.patterns.creational.abstractfactory;

public class PrivateSchoolDirector implements Director{

    @Override
    public void manage() {
        System.out.println("Manages staff very well");
    }
}

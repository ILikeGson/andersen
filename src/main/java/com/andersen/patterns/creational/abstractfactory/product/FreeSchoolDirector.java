package com.andersen.patterns.creational.abstractfactory.product;

public class FreeSchoolDirector implements Director{

    @Override
    public void manage() {
        System.out.println("Director: Badly manages staff");
    }
}

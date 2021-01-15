package com.andersen.patterns.creational.abstractfactory;

public class FreeSchoolDirector implements Director{

    @Override
    public void manage() {
        System.out.println("Badly manages staff");
    }
}

package com.andersen.patterns.creational.abstractfactory.product;

public class PrivateSchoolTeacher implements Teacher{

    @Override
    public void teach() {
        System.out.println("Teacher: Teaches students very well");
    }
}

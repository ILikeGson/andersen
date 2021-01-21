package com.andersen.patterns.creational.abstractfactory.product;

public class FreeSchoolTeacher implements Teacher{
    @Override
    public void teach() {
        System.out.println("Teacher: Teaches students badly");
    }
}

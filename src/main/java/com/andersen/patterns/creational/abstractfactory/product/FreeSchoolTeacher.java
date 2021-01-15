package com.andersen.patterns.creational.abstractfactory;

public class FreeSchoolTeacher implements Teacher{
    @Override
    public void teach() {
        System.out.println("Teaches students badly");
    }
}

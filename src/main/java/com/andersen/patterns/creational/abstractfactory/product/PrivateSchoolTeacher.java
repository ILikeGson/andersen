package com.andersen.patterns.creational.abstractfactory;

public class PrivateSchoolTeacher implements Teacher{

    @Override
    public void teach() {
        System.out.println("Teaches students very well");
    }
}

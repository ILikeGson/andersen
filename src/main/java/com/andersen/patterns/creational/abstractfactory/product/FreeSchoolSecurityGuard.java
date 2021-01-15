package com.andersen.patterns.creational.abstractfactory;

public class FreeSchoolSecurityGuard implements SecurityGuard{

    @Override
    public void guard() {
        System.out.println("Sleeps all day - drinks all night");
    }
}

package com.andersen.patterns.creational.abstractfactory;

public class PrivateSchoolSecurityGuard implements SecurityGuard{

    @Override
    public void guard() {
        System.out.println("Criminals are afraid to approach school");
    }
}

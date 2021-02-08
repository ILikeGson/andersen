package com.andersen.patterns.creational.abstractfactory.product;

public class PrivateSchoolSecurityGuard implements SecurityGuard{

    @Override
    public void guard() {
        System.out.println("Security Guard: Criminals are afraid to approach school");
    }
}

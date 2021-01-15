package com.andersen.patterns.creational.abstractfactory.product;

public class FreeSchoolSecurityGuard implements SecurityGuard{

    @Override
    public void guard() {
        System.out.println("Security Guard: Sleeps all day - drinks all night");
    }
}

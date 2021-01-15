package com.andersen.patterns.creational.abstractfactory;

public class FreeSchool implements AbstractSchool{
    @Override
    public Director createDirector() {
        return null;
    }

    @Override
    public Teacher createTeacher() {
        return null;
    }

    @Override
    public SecurityGuard createSecurityGuard() {
        return null;
    }
}

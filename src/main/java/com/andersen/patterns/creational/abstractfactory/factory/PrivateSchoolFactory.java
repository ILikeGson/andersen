package com.andersen.patterns.creational.abstractfactory.factory;

import com.andersen.patterns.creational.abstractfactory.product.*;

public class PrivateSchoolFactory implements AbstractSchool {
    @Override
    public Director createDirector() {
        return new PrivateSchoolDirector();
    }

    @Override
    public Teacher createTeacher() {
        return new PrivateSchoolTeacher();
    }

    @Override
    public SecurityGuard createSecurityGuard() {
        return new PrivateSchoolSecurityGuard();
    }
}

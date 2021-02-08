package com.andersen.patterns.creational.abstractfactory.factory;

import com.andersen.patterns.creational.abstractfactory.product.*;

public class FreeSchoolFactory implements AbstractSchool {
    @Override
    public Director createDirector() {
        return new FreeSchoolDirector();
    }

    @Override
    public Teacher createTeacher() {
        return new FreeSchoolTeacher();
    }

    @Override
    public SecurityGuard createSecurityGuard() {
        return new FreeSchoolSecurityGuard();
    }
}

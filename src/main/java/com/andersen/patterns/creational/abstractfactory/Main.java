package com.andersen.patterns.creational.abstractfactory;

import com.andersen.patterns.creational.abstractfactory.factory.AbstractSchool;
import com.andersen.patterns.creational.abstractfactory.factory.FreeSchoolFactory;
import com.andersen.patterns.creational.abstractfactory.product.Director;
import com.andersen.patterns.creational.abstractfactory.product.SecurityGuard;
import com.andersen.patterns.creational.abstractfactory.product.Teacher;

public class Main {
    public static void main(String[] args) {
        AbstractSchool school = new FreeSchoolFactory();
        Director director = school.createDirector();
        Teacher teacher = school.createTeacher();
        SecurityGuard securityGuard = school.createSecurityGuard();

        director.manage();
        teacher.teach();
        securityGuard.guard();

    }
}

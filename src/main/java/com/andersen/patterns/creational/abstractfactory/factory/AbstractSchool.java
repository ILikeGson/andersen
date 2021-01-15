package com.andersen.patterns.creational.abstractfactory.factory;

import com.andersen.patterns.creational.abstractfactory.product.Director;
import com.andersen.patterns.creational.abstractfactory.product.SecurityGuard;
import com.andersen.patterns.creational.abstractfactory.product.Teacher;

public interface AbstractSchool {
    Director createDirector();
    Teacher createTeacher();
    SecurityGuard createSecurityGuard();
}

package com.andersen.patterns.creational.abstractfactory;

public interface AbstractSchool {
    Director createDirector();
    Teacher createTeacher();
    SecurityGuard createSecurityGuard();
}

package com.andersen;

public final class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public final String showPersonInfo(){
        return String.format("first name: %s\nlast name: %s\nage: %d", firstName, lastName, age);
    }
}

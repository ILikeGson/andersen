package com.andersen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private static final String personInfo = "first name: Evgeny\nlast name: Ivanov\nage: 26";
    private Person person;
    private Person secondPerson;

    @BeforeEach
    void init() {
        person = new Person("Evgeny", "Ivanov", 26);
        secondPerson = new Person("Evgeny", "Ivanov", 26);
    }

    @Test
    void shouldReturnPersonsInfo() {
        assertEquals(person.showPersonInfo(), personInfo);
    }

    @Test
    void shouldCompareDifferentLinksAndReturnTheyAreNotEqual() {
        assertNotSame(person, secondPerson);
    }

    @Test
    void shouldCompareSameLinksAndReturnTheyAreEqual() {
        secondPerson = person;
        assertSame(person, secondPerson);
    }
}
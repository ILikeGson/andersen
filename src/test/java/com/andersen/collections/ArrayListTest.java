package com.andersen.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    private ArrayList<String> arrayList;

    @BeforeEach
    void fillList() {
        arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
    }

    @Test
    void add() {
        arrayList.add("5");
        assertEquals(arrayList.size(), 5);
        assertEquals(arrayList.get(4), "5");

    }

    @Test
    void get() {
        assertEquals(arrayList.get(2), "3");
        assertEquals(arrayList.get(3), "4");
        assertThrows(IndexOutOfBoundsException.class, () -> arrayList.get(5));
    }

    @Test
    void size() {
        assertEquals(arrayList.size(), 4);
    }

    @Test
    void set() {
        arrayList.set(0, "20");
        assertEquals(arrayList.get(0), "20");
    }

    @Test
    void remove() {
        arrayList.remove(3);
        assertEquals(arrayList.size(), 3);
    }
}
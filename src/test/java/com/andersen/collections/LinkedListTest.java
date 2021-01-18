package com.andersen.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void get() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        assertEquals(linkedList.get(0), "1");
        assertEquals(linkedList.get(1), "2");
    }

    @Test
    void size() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        assertEquals(2, linkedList.size());
    }

    @Test
    void add() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        assertEquals(3, linkedList.size());
        assertEquals(linkedList.toString(), "LinkedList{size=3, first=item=1, last=item=3}");
    }

    @Test
    void remove() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        assertTrue(linkedList.remove("1"));
        assertEquals(linkedList.size(), 2);
    }
}
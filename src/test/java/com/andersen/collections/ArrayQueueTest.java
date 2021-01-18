package com.andersen.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    private Queue<String> data;

    @BeforeEach
    void fillList() {
        data = new Queue<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
    }

    @Test
    void isEmpty() {
        assertFalse(data.isEmpty());
    }

    @Test
    void add() {
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        assertFalse(data.isEmpty());
        assertEquals(data.size(), 15);
    }

    @Test
    void remove() {
        assertEquals(data.size(), 5);
        data.remove();
        assertEquals(data.size(), 4);
        assertEquals(data.element(), "2");
        data.remove();
        assertEquals(data.size(), 3);
        data.remove();
        assertEquals(data.size(), 2);
        data.remove();
        assertEquals(data.size(), 1);
        data.remove();
        assertEquals(data.size(), 0);
        assertThrows(NoSuchElementException.class, () -> data.remove());
    }
}
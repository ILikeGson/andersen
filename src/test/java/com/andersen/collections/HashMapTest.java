package com.andersen.collections;

import com.andersen.maps.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    private HashMap<String, String> map;

    @BeforeEach
    void init() {
        map = new HashMap<>();
        map.put("Sobolev", "1");
    }

    @Test
    void put() {
        map.put("Ivanov", "2");
        assertEquals(map.size(), 2);
        map.put("Petrov", "3");
        assertEquals(map.size(), 3);
    }

    @Test
    void get() {
        assertEquals(map.get("Sobolev"), "1");
        assertThrows(IllegalArgumentException.class, () -> map.get("lalala"));
    }

    @Test
    void containsKey() {
        assertTrue(map.containsKey("Sobolev"));
    }
}
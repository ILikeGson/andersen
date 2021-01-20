package com.andersen.sortalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortsTest {
    private static final int[] ARRAY = {7, 6, 2, 5, 1, 3, 8};
    private static final int[] EXPECTED = {1, 2, 3, 5, 6, 7, 8};

    @Test
    void bubbleSort() {
        assertEquals(Arrays.toString(Sorts.bubbleSort(ARRAY)), Arrays.toString(EXPECTED));
    }

    @Test
    void insertionSort() {
        assertEquals(Arrays.toString(Sorts.insertionSort(ARRAY)), Arrays.toString(EXPECTED));

    }

    @Test
    void selectionSort() {
        assertEquals(Arrays.toString(Sorts.selectionSort(ARRAY)), Arrays.toString(EXPECTED));
    }

    @Test
    void shuttleSort() {
        assertEquals(Arrays.toString(Sorts.shuttleSort(ARRAY)), Arrays.toString(EXPECTED));
    }

    @Test
    void quickSortTest() {
        assertEquals(Arrays.toString(Sorts.quickSort(ARRAY, 0, ARRAY.length-1)), Arrays.toString(EXPECTED));

    }

    @Test
    void mergeSort() {
        assertEquals(Arrays.toString(Sorts.mergeSort(ARRAY, 0, ARRAY.length-1)), Arrays.toString(EXPECTED));
    }
}
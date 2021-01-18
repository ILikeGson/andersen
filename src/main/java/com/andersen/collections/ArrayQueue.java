package com.andersen.collections;


import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayQueue<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public ArrayQueue() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E element) {
        if ((size + 1) > data.length) {
            copyInternalArray(0, grow());
        }
        for (int i = 0; i < data.length; i++) {
            if (Objects.isNull(data[i])) {
                data[i] = element;
                break;
            }
        }
        size++;
        return true;
    }
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Object retrievedElement = data[0];
        copyInternalArray(1, data.length);
        size--;
        return (E) retrievedElement;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Object retrievedElement = data[0];
        copyInternalArray(1, data.length - 1);
        size--;
        return (E) retrievedElement;
    }

    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (E) data[0];
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) data[0];
    }

    public int size() {
        return size;
    }

    private int grow() {
        return (int) Math.round(data.length * 1.5);
    }

    private void copyInternalArray(int from, int length) {
        Object[] newArray = new Object[length];
        data = Arrays.copyOfRange(data, from, length);
    }

    @Override
    public String toString() {
        return "Queue{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}

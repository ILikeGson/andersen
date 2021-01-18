package com.andersen.collections;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> {
    private int size;
    private Object[] array;

    public ArrayList() {
        this.array = new Object[10];
    }

    public void add(E element) {
        if (size + 1 <= array.length) {
            for (int i = 0; i < array.length; i++) {
                if (Objects.isNull(array[i])) {
                    array[i] = element;
                    break;
                }
            }
        } else {
            expandAndCopyInternalArray();
            for (Object object : array) {
                if (Objects.isNull(object)) {
                    object = element;
                }
            }
        }
        size++;
    }

    public E get(int index) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (E) array[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        E oldValue = (E) array[index];
        array[index] = element;
        return oldValue;
    }

    public void remove(int index) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = null;
        size--;
    }

    private void expandAndCopyInternalArray() {
        int newLength = (int) Math.round(array.length * 1.5);
        Object[] newArray = new Object[newLength];
        for (int i = 0; i < newLength; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private boolean validIndex(int index) {
        if (index >= 0 && index < size) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}

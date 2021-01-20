package com.andersen.sortalgorithms;

public class Sorts {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int current = array[j];
                if (current > array[j+1]) {
                    array[j] = array[j+1];
                    array[j+1] = current;
                }
            }
        }
        return array;
    }

    public static int[] insertionSort(int [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                int currentElement = array[j];
                if (currentElement < array[j-1]) {
                    array[j] = array[j-1];
                    array[j-1] = currentElement;
                } else {
                    break;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (currentValue > array[j]) {
                    currentValue = array[j];
                    minIndex = j;
                }
            }
            if (array[i] > array[minIndex]) {
                array[minIndex] = array[i];
                array[i] = currentValue;
            }
        }
        return array;
    }

    public static int[] shuttleSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int value = array[i];
                array[i] = array[i-1];
                array[i-1] = value;
                for (int z = i - 1; (z - 1) >= 0; z--) {
                    if (array[z] < array[z - 1]) {
                        int newValue = array[z];
                        array[z] = array[z-1];
                        array[z-1] = value;
                    } else {
                        break;
                    }
                }
            }
        }
        return array;
    }

    public static int[] quickSort(int[] array, int low, int high) {
        int j = 0;
        if (low == high) {
            return array;
        }
        if (low < high) {
            int pivot = array[low];
            int i = low;
            j = high;
            while (i < j) {
                do {
                    i++;
                } while (array[i] <= pivot);
                do {
                    j--;
                } while (array[j] > pivot);
                if (i < j) {
                    int val = array[j];
                    array[j] = array[i];
                    array[i] = val;
                }
            }
            int val = array[low];
            array[low] = array[j];
            array[j] = val;
            quickSort(array, low, j);
            quickSort(array, j+1, high);
        }
        return array;
    }
    public static int[] mergeSort(int[] array, int low, int high) {
        if (high <= low) {
            return array;
        }

        int mid = (low+high)/2;
        mergeSort(array, low, mid);
        mergeSort(array, mid+1, high);

        int[] leftArray = new int[mid - low + 1];
        int[] rightArray = new int[high - mid];


        System.arraycopy(array, low, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        return array;
    }
}

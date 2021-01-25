package com.andersen.streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        multiplyEachElementOf2();
        increaseMapValueAndDisplay();
        executeParallelProcessAndIncreaseValueThenCompare();
        addValuesToStream();
    }

    public static void multiplyEachElementOf2() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream().map(element -> element * 2).forEach(System.out::println);

    }

    public static void increaseMapValueAndDisplay() {
        Map<String, Integer> map = Map.of("key", 2);
        map.values().stream().map(element -> element + 1).forEach(System.out::println);
    }

    public static void executeParallelProcessAndIncreaseValueThenCompare() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.parallelStream().map(x -> x + 1).forEach(System.out::println);
        list.parallelStream().map(x -> x + 1).forEachOrdered(System.out::println);
    }

    private static void addValuesToStream() {
        Stream.concat(List.of(1,2,3).stream(), Stream.of(4, 5, 6)).forEach(System.out::println);
    }

}


package com.andersen.patterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        DellMonitor dellMonitor = new DellMonitor(new Red());
        dellMonitor.display();
    }
}

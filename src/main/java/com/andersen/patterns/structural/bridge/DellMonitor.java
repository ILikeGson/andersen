package com.andersen.patterns.structural.bridge;

public class DellMonitor extends Monitor{
    public DellMonitor(Color color) {
        super(color);
    }

    @Override
    void display() {
        getColor().print();
    }
}

package com.andersen.patterns.structural.bridge;

public class HpMonitor extends Monitor {
    public HpMonitor(Color color) {
        super(color);
    }

    @Override
    void display() {
        getColor().print();
    }
}

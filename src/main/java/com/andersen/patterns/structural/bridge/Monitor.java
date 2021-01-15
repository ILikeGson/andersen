package com.andersen.patterns.structural.bridge;

public abstract class Monitor {
    private Color color;

    public Monitor(Color color) {
        this.color = color;
    }

    abstract void display();

    public Color getColor() {
        return color;
    }
}

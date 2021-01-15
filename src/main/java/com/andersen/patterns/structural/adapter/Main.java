package com.andersen.patterns.structural.adapter;

public class Main {
    public static void main(String[] args) {
        AdapterJsonToXml adapter = new AdapterJsonToXml(new JsonParser());
        adapter.parse();
    }
}

package com.andersen.patterns.structural.proxy;

public class InternetClient implements Client{
    @Override
    public void pay() {
        System.out.println("Client paid");
    }
}

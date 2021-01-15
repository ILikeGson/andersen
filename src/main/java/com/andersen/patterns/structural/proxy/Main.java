package com.andersen.patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        ProxyInternetClient client = new ProxyInternetClient();
        client.pay();
    }
}

package com.andersen.patterns.structural.proxy;

public class ProxyInternetClient implements Client{
    private InternetClient client;

    @Override
    public void pay() {
        client = new InternetClient();
        client.pay();
    }
}

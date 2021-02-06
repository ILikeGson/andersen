package com.andersen.shop;

public class AppLauncher {

    public static void main(String[] args) {
        RequestHandler requestHandler = new RequestHandler(new InternetShop(), new ConsoleIOService());
        requestHandler.handleRequest();
    }
}

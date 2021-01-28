package com.andersen.shop;

import java.util.Scanner;

public class RequestHandler {
    private final InternetShop shop;
    private final ConsoleIOService service;

    public RequestHandler(InternetShop shop, ConsoleIOService service) {
        this.shop = shop;
        this.service = service;
    }

    public void handleRequest() {
        String request = "";
        String[] partsOfRequest;
        while (!(request = service.getUserInput()).equals("exit")) {
            partsOfRequest = parse(request);
            String command = partsOfRequest[0].trim();
            if (command.equalsIgnoreCase("showProducts")) {
                shop.showAllProducts();
            } else if (command.equalsIgnoreCase("showProductsInTheBucket")) {
                shop.showProductsInBucket();
            } else if (command.equalsIgnoreCase("addProductToTheBucket")) {
                shop.addProductToBucketById(Integer.parseInt(partsOfRequest[1].trim()));
            } else if (command.equalsIgnoreCase("deleteProductFromTheBucket")) {
                shop.removeFromBucketById(Integer.parseInt(partsOfRequest[1].trim()));
            } else if (command.equalsIgnoreCase("clear")) {
                shop.clear();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }


    private String[] parse(String str) {
        return str.split(",");
    }
}

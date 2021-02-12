package com.andersen.shop;

import com.andersen.shop.model.InternetShop;

public class RequestHandler {
    private final InternetShop shop;
    private final ConsoleIOService service;

    public RequestHandler(InternetShop shop, ConsoleIOService service) {
        this.shop = shop;
        this.service = service;
    }

    public void handleRequest(int userId) {
        String request;
        String[] partsOfRequest;
        while (!(request = service.getUserInput()).equals("exit")) {
            partsOfRequest = parse(request);
            String command = partsOfRequest[0].trim();
            if (command.equalsIgnoreCase("showProducts")) {
                shop.showAllProducts();
            } else if (command.equalsIgnoreCase("showProductsInTheBucket")) {
                shop.showProductsInBucket(userId);
            } else if (command.equalsIgnoreCase("addProductToTheBucket")) {
                shop.addProductToBucketById(Integer.parseInt(partsOfRequest[1].trim()), userId);
            } else if (command.equalsIgnoreCase("deleteProductFromTheBucket")) {
                shop.removeFromBucketById(Integer.parseInt(partsOfRequest[1].trim()), userId);
            } else if (command.equalsIgnoreCase("clear")) {
                shop.clear(userId);
            } else {
                throw new IllegalArgumentException();
            }
        }
        Serializer.serialize(shop);
    }


    private String[] parse(String str) {
        return str.split(",");
    }
}

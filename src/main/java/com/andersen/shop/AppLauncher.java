package com.andersen.shop;

import com.andersen.shop.dao.ProductDaoImpl;

public class AppLauncher {

    public static void main(String[] args) {
        new ProductDaoImpl().getAll().forEach(System.out::println);
        InternetShop shop = Serializer.deserialize();
        User user = new User("Vasya", "Ivanov", Currencies.uah());
        shop.addUser(user);
        RequestHandler requestHandler = new RequestHandler(shop, new ConsoleIOService());
        requestHandler.handleRequest(shop.getUsers().get(0).getId());
    }
}

package com.andersen.shop;

import com.andersen.shop.model.InternetShop;

import java.io.*;

public class Serializer {
    private static final String PATH_TO_FILE = "classpath:/";
    private static final String FILENAME = "products.txt";

    public static void serialize(InternetShop shop) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILENAME));
            objectOutputStream.writeObject(shop);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert objectOutputStream != null;
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static InternetShop deserialize() {
        if(new File("products.txt").length() == 0) {
            return InternetShop.getInstance();
        }
        ObjectInputStream objectInputStream = null;
        InternetShop shop = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(FILENAME));
            shop = (InternetShop) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return shop;
    }
}

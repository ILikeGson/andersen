package com.andersen.multithreading;


public class CryptEncoder {
    public static synchronized void incrementAndWriteIntoConsole(Resource resource) {
        String data = resource.getText();
        System.out.println(data.replaceAll("[aeoyu]", "admin"));
    }
}

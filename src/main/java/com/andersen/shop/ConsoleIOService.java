package com.andersen.shop;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleIOService {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;

    @SneakyThrows
    public String getUserInput(){
        return reader.readLine();
    }
}

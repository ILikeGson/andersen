package com.andersen.patterns.creational.factorymethod;

import com.andersen.patterns.creational.factorymethod.creator.Driver;
import com.andersen.patterns.creational.factorymethod.creator.MySqlDriver;
import com.andersen.patterns.creational.factorymethod.creator.PostgreSqlDriver;
import com.andersen.patterns.creational.factorymethod.product.Connection;

public class Main {
    public static void main(String[] args) {
        Driver driver = createDriverByName("mysql");
        Connection connection = driver.createDatabaseConnection();
        connection.saveInfo();
        connection.readInfo();
    }

    static Driver createDriverByName(String name) {
        if (name.equalsIgnoreCase("mysql")) {
            return new MySqlDriver();
        }
        else if (name.equalsIgnoreCase("postgresql")) {
            return new PostgreSqlDriver();
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

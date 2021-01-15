package com.andersen.patterns.creational.factorymethod.creator;

import com.andersen.patterns.creational.factorymethod.product.Connection;
import com.andersen.patterns.creational.factorymethod.product.MySqlConnection;

public class MySqlDriver implements Driver {

    @Override
    public Connection createDatabaseConnection() {
        return new MySqlConnection();
    }
}

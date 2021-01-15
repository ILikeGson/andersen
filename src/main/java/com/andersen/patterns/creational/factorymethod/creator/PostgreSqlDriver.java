package com.andersen.patterns.creational.factorymethod.creator;

import com.andersen.patterns.creational.factorymethod.product.Connection;
import com.andersen.patterns.creational.factorymethod.product.PostgreSqlConnection;

public class PostgreSqlDriver implements Driver{

    @Override
    public Connection createDatabaseConnection() {
        return new PostgreSqlConnection();
    }
}

package com.andersen.patterns.creational.factorymethod.product;

import com.andersen.patterns.creational.factorymethod.product.Database;

public class PostgreSql implements Database {

    @Override
    public void saveInfo() {
        System.out.println("Postgres DBMS saved info");
    }

    @Override
    public void readInfo() {
        System.out.println("Postgres DBMS has read info");
    }
}

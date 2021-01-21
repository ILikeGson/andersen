package com.andersen.patterns.creational.factorymethod.product;

public class PostgreSqlConnection implements Connection {

    @Override
    public void saveInfo() {
        System.out.println("Postgres DBMS saved info");
    }

    @Override
    public void readInfo() {
        System.out.println("Postgres DBMS has read info");
    }
}

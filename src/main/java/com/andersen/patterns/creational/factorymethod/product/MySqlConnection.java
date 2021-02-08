package com.andersen.patterns.creational.factorymethod.product;

public class MySqlConnection implements Connection {

    @Override
    public void saveInfo() {
        System.out.println("MySql DBMS saved info");
    }

    @Override
    public void readInfo() {
        System.out.println("MySql DBMS has read info");
    }
}

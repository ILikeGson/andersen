package com.andersen.patterns.creational.factorymethod.product;

import com.andersen.patterns.creational.factorymethod.product.Database;

public class MySql implements Database {

    @Override
    public void saveInfo() {
        System.out.println("MySql DBMS saved info");
    }

    @Override
    public void readInfo() {
        System.out.println("MySql DBMS has read info");
    }
}

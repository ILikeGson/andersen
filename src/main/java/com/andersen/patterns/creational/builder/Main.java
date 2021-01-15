package com.andersen.patterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        HouseBuilder builder = new PrivateHouseBuilder();
        House myHouse = builder.createHouse()
                .buildColor()
                .buildCompany()
                .buildDoors()
                .buildFloors()
                .buildRooms()
                .build();
        System.out.println(myHouse);
    }
}

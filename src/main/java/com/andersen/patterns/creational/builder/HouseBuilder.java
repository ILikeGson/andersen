package com.andersen.patterns.creational.builder;

public interface HouseBuilder {

    HouseBuilder createHouse();
    HouseBuilder buildRooms();
    HouseBuilder buildCompany();
    HouseBuilder buildColor();
    HouseBuilder buildDoors();
    HouseBuilder buildFloors();
    House build();

}

package com.andersen.patterns.creational.builder;

public class PrivateHouseBuilder implements HouseBuilder{
    private House house;

    @Override
    public HouseBuilder createHouse() {
        house = new House();
        return this;
    }

    @Override
    public HouseBuilder buildRooms() {
        house.setRoomsNumber(5);
        return this;
    }

    @Override
    public HouseBuilder buildCompany() {
        house.setCompany(Company.LSR);
        return this;
    }

    @Override
    public HouseBuilder buildColor() {
        house.setColor(Color.WHITE);
        return this;
    }

    @Override
    public HouseBuilder buildDoors() {
        house.setDoorsNumber(15);
        return this;
    }

    @Override
    public HouseBuilder buildFloors() {
        house.setFloorsNumber(1);
        return this;
    }

    @Override
    public House build() {
        return house;
    }
}

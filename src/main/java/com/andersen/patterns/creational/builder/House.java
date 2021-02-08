package com.andersen.patterns.creational.builder;

public class House {
    private Company company;
    private Color color;
    private int floorsNumber;
    private int doorsNumber;
    private int roomsNumber;

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public void setDoorsNumber(int doorsNumber) {
        this.doorsNumber = doorsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                "company=" + company +
                ", color=" + color +
                ", floorsNumber=" + floorsNumber +
                ", doorsNumber=" + doorsNumber +
                ", roomsNumber=" + roomsNumber +
                '}';
    }
}

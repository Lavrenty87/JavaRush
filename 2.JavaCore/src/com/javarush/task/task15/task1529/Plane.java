package com.javarush.task.task15.task1529;

public class Plane implements CanFly {
    int canDrivePeople;

    public Plane(int canDrivePeople) {
        this.canDrivePeople = canDrivePeople;
    }

    @Override
    public void fly() {

    }
}

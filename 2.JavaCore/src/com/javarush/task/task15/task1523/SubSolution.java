package com.javarush.task.task15.task1523;

public class SubSolution extends Solution {
    String country;
    int counter;

    public SubSolution(String model, int arg, double power, String country, int counter) {
        super(model, arg, power);
        this.country = country;
        this.counter = counter;
    }

    SubSolution(String model, int arg, String country, int counter) {
        super(model, arg);
        this.country = country;
        this.counter = counter;
    }

    protected SubSolution(int arg, double power, String country, int counter) {
        super(arg, power);
        this.country = country;
        this.counter = counter;
    }
}

package com.javarush.task.task14.task1409;

public class SuspensionBridge implements Bridge {
    int carsCount = 1000;
    @Override
    public int getCarsCount() {
        return carsCount;
    }
}

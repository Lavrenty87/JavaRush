package com.javarush.task.task14.task1408;

import javafx.scene.SnapshotParameters;

import static com.javarush.task.task14.task1408.Country.RUSSIA;

public class RussianHen extends Hen {
    int N = 1500;
    String country = RUSSIA;

    @Override
    public int getCountOfEggsPerMonth() {
        return N;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + country + ". Я несу " +
                getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

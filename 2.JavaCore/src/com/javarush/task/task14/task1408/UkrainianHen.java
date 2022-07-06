package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.UKRAINE;

public class UkrainianHen extends Hen {
    int N = 90;
    String country = UKRAINE;

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

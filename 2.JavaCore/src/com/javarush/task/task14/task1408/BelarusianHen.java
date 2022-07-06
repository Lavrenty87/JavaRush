package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    int N = 100;
    String country = Country.BELARUS;

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

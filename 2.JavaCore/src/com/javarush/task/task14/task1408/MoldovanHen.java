package com.javarush.task.task14.task1408;

import static com.javarush.task.task14.task1408.Country.MOLDOVA;

public class MoldovanHen extends Hen {
    int N = 110;
    String country = MOLDOVA;

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

package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> list;
    private int  ORDER_CREATING_INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> list, int ORDER_CREATING_INTERVAL) {
        this.list = list;
        this.ORDER_CREATING_INTERVAL = ORDER_CREATING_INTERVAL;
    }

    @Override
    public void run() {
        int i = (int) (Math.random() * 10);
        while (!(i <= list.size() - 1)) {
            i = (int) (Math.random() * 10);
        }
        Tablet t = list.get(i);
        while (true) {
            t.createTestOrder();
            try {
                Thread.sleep(ORDER_CREATING_INTERVAL);
            } catch (InterruptedException e) {
            }
        }
    }
}

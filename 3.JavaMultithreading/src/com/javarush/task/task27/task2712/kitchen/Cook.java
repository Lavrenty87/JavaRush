package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

public class Cook implements Runnable {
    private String name;
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<Order> queueReady = new LinkedBlockingQueue<>();
    private boolean busy;

    public Cook(String name) {
        this.name = name;
        busy = false;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public void setQueueReady(LinkedBlockingQueue<Order> queueReady) {
        this.queueReady = queueReady;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        busy = true;
        try {
            sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ConsoleHelper.writeMessage("Start cooking - " + order.toString());
        CookedOrderEventDataRow cookedOrderEventDataRow = new CookedOrderEventDataRow(order.toString(), name,
                order.getTotalCookingTime() * 60, order.getDishes());
        StatisticManager.getInstance().register(cookedOrderEventDataRow);
        busy = false;
        queueReady.add(order);
    }

    @Override
    public void run() {
        while (true) {
            if (!queue.isEmpty()) {
                if (!this.isBusy()) {
                    try {
                        this.startCookingOrder(queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
            }
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

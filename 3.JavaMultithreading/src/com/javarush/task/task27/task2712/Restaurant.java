package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> ORDER_QUEUE = new LinkedBlockingQueue<>();
    private static final LinkedBlockingQueue<Order> READY_ORDER_QUEUE = new LinkedBlockingQueue<>();
    public static void main(String[] args) {
        ArrayList<Tablet> tablet = new ArrayList<>();
        Cook cook1 = new Cook("Shef");
        cook1.setQueue(ORDER_QUEUE);
        cook1.setQueueReady(READY_ORDER_QUEUE);
        Cook cook2 = new Cook("Shef2");
        cook2.setQueue(ORDER_QUEUE);
        cook2.setQueueReady(READY_ORDER_QUEUE);

        for (int i = 0; i < 5; i++){
            Tablet t = new Tablet(i+1);
            t.setQueue(ORDER_QUEUE);
            tablet.add(t);
        }
        Waiter waiter = new Waiter();
        waiter.setQueueReady(READY_ORDER_QUEUE);
        Thread threadC1 = new Thread(cook1);
        Thread threadC2 = new Thread(cook2);
        threadC1.start();
        threadC2.start();
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablet, 100));
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printArchivedVideoSet();
        directorTablet.printCookWorkloading();
    }
}

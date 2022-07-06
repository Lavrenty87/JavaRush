package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            if (!order.isEmpty()) {
                new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
                queue.add(order);
            } else return null;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException ee) {
        StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(order.getTotalCookingTime()));
        logger.log(Level.INFO, "No video is available for the order " + order);
    }
        return order;
    }

    public void createTestOrder() {
        TestOrder testOrder = null;
        try {
            testOrder = new TestOrder(this);
            testOrder.getDishes();
            if (!testOrder.isEmpty()) {
                new AdvertisementManager(testOrder.getTotalCookingTime() * 60).processVideos();
                queue.add(testOrder);
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        } catch (NoVideoAvailableException ee) {
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(testOrder.getTotalCookingTime()));
            logger.log(Level.INFO, "No video is available for the order " + testOrder);
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}

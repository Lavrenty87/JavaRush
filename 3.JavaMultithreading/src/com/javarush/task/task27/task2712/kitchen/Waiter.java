package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Waiter implements Runnable {
    private LinkedBlockingQueue<Order> queueReady = new LinkedBlockingQueue<>();

    public void setQueueReady(LinkedBlockingQueue<Order> queueReady) {
        this.queueReady = queueReady;
    }

    /*@Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage(arg.toString() + " was cooked by " + o.toString());
    }*/

    @Override
    public void run() {
        while (true){
            if (queueReady.isEmpty()) continue;
            try {
                Order order = queueReady.take();
                ConsoleHelper.writeMessage(order.toString() + " was cooked by ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

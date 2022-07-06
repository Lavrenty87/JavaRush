package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
        while (true){
            return consoleReader.readLine();
        }


    }
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> orderAllDish = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда, или \"exit\" для отмены заказа.");
        String order = readString();
        Dish[] restDish = Dish.values().clone();
        while (!order.equalsIgnoreCase("exit")){
            for (int i = 0; i < restDish.length; i++) {
                if (order.equalsIgnoreCase(restDish[i].toString())) {
                    orderAllDish.add(restDish[i]);
                    break;
                }
                if (i == restDish.length-1) writeMessage("Такого блюда нет в мню попробуйте ещё раз.");
            }
            order = readString();
        }
        return orderAllDish;
    }
}

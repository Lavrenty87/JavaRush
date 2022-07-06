package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() {
        dishes = new ArrayList<>();
        Dish[] dishesArr = Dish.values();
        int countDish = (int) (Math.random() * 10);
        for (int i = 0; i < countDish; i++){
            int randomNum = (int) (Math.random() * dishesArr.length);
            dishes.add(dishesArr[randomNum]);
        }
    }
}

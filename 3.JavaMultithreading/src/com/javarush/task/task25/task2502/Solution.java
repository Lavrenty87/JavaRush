package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws IllegalAccessException {
            //init wheels here
            Set<Wheel> sw = new HashSet<>(4);
            String[] a = loadWheelNamesFromDB();
            if (a.length != 4) throw new IllegalAccessException();

            for (String l : a) {
                sw.add(Wheel.valueOf(l));
            }
            if (sw.size() != 4) throw new IllegalAccessException();
            wheels = new ArrayList<>(sw);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}

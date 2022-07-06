package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/

import java.util.LinkedList;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        LinkedList<String> list = new LinkedList<>();
        while (e != null) {
            list.add(0, e.toString());

            e = e.getCause();
        }
        list.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}

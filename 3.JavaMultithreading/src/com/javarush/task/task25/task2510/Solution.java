package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String s;
                if (e instanceof Error) s = "Нельзя дальше работать";
                else if (e instanceof Exception) s = "Надо обработать";
                else s = "Поживем - увидим";
                System.out.println(s);
            }
        });
    }

    public static void main(String[] args) {
    }
}

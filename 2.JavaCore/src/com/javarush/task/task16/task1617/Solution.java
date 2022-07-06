package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        if (clock.isInterrupted()) System.out.print(" Марш!");
        if (!clock.isInterrupted()) {
            clock.interrupt();
        }

    }


    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            System.out.print(" " + numSeconds);
            while (numSeconds > 0) {
                numSeconds--;
                try {
                    Thread.sleep(1000);
                    if (!isInterrupted()){
                        if (numSeconds == 0) {
                            System.out.print(" Марш!");
                        }
                        else System.out.print(" " + numSeconds);
                    }
                } catch (InterruptedException e) {

                    e.printStackTrace();
                    System.out.print(" Прервано!");
                }
            }
        }
    }
}

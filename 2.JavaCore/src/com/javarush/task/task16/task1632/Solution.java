package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) throws InterruptedException {
        threads.get(3).start();
        Thread.sleep(6000);
        if (threads.get(3).isAlive()) {
            ((Thread4) threads.get(3)).showWarning();
        }
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true){
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();
            }catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    private static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.currentThread().sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Thread4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    private static class Thread5 extends Thread {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        @Override
        public void run() {
            try {
                int sum = 0;
                String red = reader.readLine();
                while (!red.equals("N")) {
                    sum += Integer.parseInt(red);
                    red = reader.readLine();
                }
                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
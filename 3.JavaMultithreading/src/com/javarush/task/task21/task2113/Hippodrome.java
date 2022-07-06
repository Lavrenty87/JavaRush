package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void print() {
        horses.forEach(Horse::print);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winner = horses.get(0);
        for (int i = 1; i < horses.size(); i++) {
            if (winner.getDistance() < horses.get(i).getDistance()) winner = horses.get(i);
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public static void main (String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Horse1", 3, 0));
        horses.add(new Horse("Horse2", 3, 0));
        horses.add(new Horse("Horse3", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}

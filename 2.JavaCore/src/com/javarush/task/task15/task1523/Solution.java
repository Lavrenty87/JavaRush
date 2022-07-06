package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    String model;
    int arg;
    double power;

    private Solution() {
    }

    protected Solution(String model, int arg, double power) {
        this.model = model;
        this.arg = arg;
        this.power = power;
    }

    Solution(String model, int arg) {
        this.model = model;
        this.arg = arg;
    }

    public Solution(int arg, double power) {
        this.arg = arg;
        this.power = power;
    }

    public static void main(String[] args) {

    }
}


package com.javarush.task.task15.task1508;

/* 
ООП - Перегрузка - убираем лишнее
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

    /*public static void print(byte b) {
        System.out.println("Я буду Java прогером!");
    }*/

    /*public static void print(double d) {
        System.out.println("Я буду Java прогером!");
    }*/ //так тоже будет работать если зкомпилить лонг потому что расш ирение byte>short>int>long>float>double

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    } //так правельно потому что расгирение byte>short>int>long>float>double

    /*public static void print(float f) {
        System.out.println("Я буду Java прогером!");
    }*/

    /*public static void print(char c) {
        System.out.println("Я буду Java прогером!");
    }*/
}

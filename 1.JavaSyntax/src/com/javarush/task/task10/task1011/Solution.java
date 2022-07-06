package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        char[] arr = new char[s.length()];
        //напишите тут ваш код
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        for (int i = 0; i < 40; i++) {

            for (int j = i; j < arr.length; j++) System.out.print(arr[j]);
            System.out.println();
        }
    }

}


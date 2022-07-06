package com.javarush.task.task30.task3013;

/* 
Битовые операции
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        System.out.println(Integer.toString(number |= (number >>  1), 2));
        System.out.println(Integer.toString(number |= (number >>  2), 2));
        System.out.println(Integer.toString(number |= (number >>  4), 2));
        System.out.println(Integer.toString(number |= (number >>  8), 2));
        System.out.println(Integer.toString(number |= (number >> 16), 2));

        return number &~ (number >> 1);
    }
}
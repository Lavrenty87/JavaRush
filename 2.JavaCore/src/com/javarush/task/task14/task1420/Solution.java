package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a1 = Integer.parseInt(reader.readLine());
        int a2 = Integer.parseInt(reader.readLine());
        if (a1 <= 0 | a2 <= 0) throw new IOException();
        System.out.println(nod(a1,a2));
    }

    static int nod (int a, int b) {
        int d = 1;
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++ ) {
                if ((a % i == 0) && (b % j == 0) && i == j) d = d * i;
            }
        }
        return d;
    }
}

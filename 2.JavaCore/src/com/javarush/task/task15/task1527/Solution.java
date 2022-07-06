package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            URL url = new URL(reader.readLine());
            String [] array = url.getQuery().split("&");
            String d = null;
            for (String a : array) {
                String [] arr = a.split("=");
                System.out.print(arr[0] + " ");
                if (arr[0].equals("obj")) d = arr[1];
            }
            if (d != null) {
                try {
                    double a = Double.parseDouble(d);
                    System.out.println();
                    alert(a);
                }catch (NumberFormatException e) {
                    e.printStackTrace();
                    alert(d);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}

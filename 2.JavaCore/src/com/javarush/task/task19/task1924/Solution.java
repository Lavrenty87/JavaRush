package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        BufferedReader readerNameFile = null;
        BufferedReader readFile = null;
        try {
            readerNameFile = new BufferedReader(new InputStreamReader(System.in));
            readFile = new BufferedReader(new FileReader(readerNameFile.readLine()));

            while (readFile.ready()) {
                String a = readFile.readLine();
                String[] s = a.split("\\s");
                for (int i = 0; i < s.length; i++) {
                    if (s[i].matches( "\\b(\\d|\\d\\d)\\b")) {
                        if(map.containsKey(Integer.parseInt(s[i]))) {
                            System.out.print(map.get(Integer.parseInt(s[i])) + " ");
                        }
                    }
                    else System.out.print(s[i] + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                readerNameFile.close();
                readFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        BufferedReader read = null;
        BufferedReader readFile = null;
        try {
            read = new BufferedReader(new InputStreamReader(System.in));
            readFile = new BufferedReader(new FileReader(read.readLine()));
            while (readFile.ready()) {
                String a = readFile.readLine();
                String[] arrA = a.split("\\s");
                int count = 0;
                for (String s:arrA
                     ) {
                    if (words.contains(s)) count++;
                }
                if (count == 2) System.out.println(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                Objects.requireNonNull(read).close();
                Objects.requireNonNull(readFile).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

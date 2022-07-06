package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(name);
        // более короткое решение через TreeSet множество хранящее уникальные данные т.к. Set и отсортированы по
        // возростантю по умолчанию(сортировку можно менять).
        TreeSet<Integer> excluzivBait = new TreeSet<>();
        while (fileInputStream.available() > 0) {
            excluzivBait.add(fileInputStream.read());
        }
            fileInputStream.close();
            for (int a : excluzivBait){
                System.out.print(a + " ");
            }
      /*  ArrayList<Integer> excluzivBait = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            int counter = 0;
            int nextBait = fileInputStream.read();
            for (int a:
                 excluzivBait) {
                if (a == nextBait) counter++;
            }
            if (counter == 0) excluzivBait.add(nextBait);
        }
        fileInputStream.close();
        Collections.sort(excluzivBait);
        for (int a : excluzivBait){
            System.out.print(a + " ");
        }*/

    }
}

package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> wordsWithNumbers = new ArrayList<>();
        BufferedReader readFile = null;
        BufferedWriter writFile = null;
        try {
            readFile = new BufferedReader( new FileReader(args[0]));
            writFile = new BufferedWriter(new FileWriter(args[1]));
            while (readFile.ready()) {
                String fileLine = readFile.readLine();
                String[] fileLineArr = fileLine.split("\\s");
                for (String a : fileLineArr) {
                    if (a.matches(".*\\d.*")) wordsWithNumbers.add(a);
                }
            }
            for (String a : wordsWithNumbers) writFile.write(a + " ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(readFile).close();
                Objects.requireNonNull(writFile).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

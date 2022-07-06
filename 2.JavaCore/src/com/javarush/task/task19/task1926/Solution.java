package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedReader readeFile = null;
        ArrayList<Character> listChar = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            readeFile = new BufferedReader(new FileReader(fileName));
            while (readeFile.ready()) {
                String a = readeFile.readLine();
                char[] ch = a.toCharArray();
                for (int i = ch.length - 1; i >= 0; i--) System.out.print(ch[i]);
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(reader).close();
                Objects.requireNonNull(readeFile).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine(),
                f2 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream1 = new FileInputStream(f1);
        int[] date = new int[fileInputStream1.available()];
        for (int i = 0; i < date.length; i++) {
            date[i] = fileInputStream1.read();
            System.out.print(date[i] + " ");
        }
        fileInputStream1.close();
        FileOutputStream fileOutputStream = new FileOutputStream(f2);
        for (int i = date.length - 1; i >= 0; i--) {
            fileOutputStream.write(date[i]);
        }
        fileOutputStream.close();
    }
}

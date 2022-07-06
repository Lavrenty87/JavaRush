package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine(), f2 = reader.readLine();
        FileInputStream file1 = new FileInputStream(f1);
        FileInputStream file2 = new FileInputStream(f2);
        FileOutputStream fos1 = new FileOutputStream(f1);

        byte[] list = new byte[file1.available()];
        file1.read(list);
        file1.close();

        while (file2.available() > 0) {
            fos1.write(file2.read());
        }

        fos1.write(list);

        file2.close();
        fos1.close();
    }
}

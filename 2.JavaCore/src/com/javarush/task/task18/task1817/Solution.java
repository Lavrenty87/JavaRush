package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);
        int countSimvol = 0;
        int countProbel = 0;
        while (fis.available() > 0) {
            char a = (char) fis.read();
            String b = String.valueOf(a);
            countSimvol ++;
            if (b.equals(" ")) countProbel ++;
        }

        float rezalt = ((float) countProbel / countSimvol) * 100;

        System.out.printf("%.2f", rezalt);
        fis.close();
    }
}

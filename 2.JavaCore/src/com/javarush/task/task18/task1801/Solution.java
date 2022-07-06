package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String failName = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(failName);
        int maxBait = fileInputStream.read();
        while (fileInputStream.available() > 0) {
            int nextBait = fileInputStream.read();
            if (maxBait < nextBait) maxBait = nextBait;
        }
        fileInputStream.close();
        System.out.println(maxBait);
    }
}

package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
        if (args[0].equals("-e")) {
            while (fileInputStream.available() > 0) {
                int a = fileInputStream.read() + 1;
                fileOutputStream.write(a);
            }
        }
        if (args[0].equals("-d")) {
            while (fileInputStream.available() > 0) {
                int a = fileInputStream.read() - 1;
                fileOutputStream.write(a);
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}

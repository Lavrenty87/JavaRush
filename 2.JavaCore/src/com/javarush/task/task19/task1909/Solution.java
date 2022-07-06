package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        String f1 = null, f2 = null;
        try {
            f1 = reader.readLine();
            f2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedReader readFile = null;
        BufferedWriter writFile = null;
        try {
            readFile = new BufferedReader(new FileReader(f1));
            writFile = new BufferedWriter(new FileWriter(f2));
            String s = null;
            String a = null;
            while (readFile.ready()) {
                a = String.valueOf ((char) readFile.read());
                if (s == null) {
                    if (a.equals(".")) s = "!";
                    else s = a;
                }else {
                    if (a.equals(".")) s += "!";
                    else s += a;
                }
            }
            writFile.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                readFile.close();
                writFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
/*
Пара нюансов из этой задачи.
1. Если использовать метод replace(), то указывать нужно конкретно сам символ:
writeToFile.write(readFile.readLine().replace(".", "!") + "\n");

2. Если использовать метод replaceAll(), то он работает с регулярками:
writeToFile.write(readFile.readLine().replaceAll("\\.", "\\!") + "\n");
*/

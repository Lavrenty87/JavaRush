package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
            String strReadFile = null;

            while (readFile.ready()) {
                if (strReadFile == null) strReadFile = readFile.readLine();
                else strReadFile += readFile.readLine();
            }
            String strWritFile = strReadFile.replaceAll("\\p{Punct}", "");
            writFile.write(strWritFile);
           // strReadFile.replaceAll("\\W", "");
           /* String[] arr = strReadFile.split("\\p{Punct}");
            for (String a : arr) {
                writFile.write(a);
            }*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                readFile.close();
                writFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
        while (true) {
            String  a = reader.readLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(a);
                fileInputStream.read();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(a);
                e.printStackTrace();
                break;
            }
        }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

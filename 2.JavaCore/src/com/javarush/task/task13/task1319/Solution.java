package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new FileWriter(reader.readLine()));

            while (true) {
                String s = reader.readLine();
                writer.write(s + "\n" );
                if (s.equals("exit")) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            reader.close();
            writer.close();
        }
    }
}

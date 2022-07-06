package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        BufferedInputStream readFile = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String a = reader.readLine();
            fileInputStream = new FileInputStream(a);
            readFile = new BufferedInputStream(fileInputStream);
            while(readFile.available() > 0) {

                char c = (char)readFile.read();

                System.out.print(c);
            }


        } catch (Exception e) {

            e.printStackTrace();

        }finally {
            reader.close();
            fileInputStream.close();
            readFile.close();
        }
    }
}
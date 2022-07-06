package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String filrName = null;
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        try {
            filrName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int count = 0;
        String a = null;
        FileReader fileReader = null;
        try {
            assert filrName != null;
            fileReader = new FileReader(filrName);
            while (fileReader.ready()) {
                if (a == null) a = String.valueOf((char)fileReader.read());
                else a += String.valueOf((char)fileReader.read());
            }
            String[] arr = a.split("\\W");
            for (String s : arr) {
                if (s.equals("world")) count ++;
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

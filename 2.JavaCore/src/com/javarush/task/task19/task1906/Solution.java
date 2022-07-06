package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String f1 = null;
        String f2 = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(f1);
            fileWriter = new FileWriter(f2);
            ArrayList<Integer> list = new ArrayList<>();
            while (fileReader.ready()) {
                list.add(fileReader.read());
            }
            for (int i = 0; i < list.size(); i ++) {
                if ((i + 1) % 2 == 0) fileWriter.write(list.get(i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

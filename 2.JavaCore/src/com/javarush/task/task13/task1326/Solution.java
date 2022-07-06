package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = null;
        FileInputStream fileInputStream = null;
        Scanner readFile = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            fileInputStream = new FileInputStream(file);
            readFile = new Scanner(fileInputStream);
            ArrayList<Integer> set = new ArrayList<>();
            while(readFile.hasNext()) {
                 int a = readFile.nextInt();
                 if (a % 2 == 0) set.add(a);
            }
            Collections.sort(set);
            for (int i : set) {
                System.out.println(i);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert reader != null;
                reader.close();
                assert fileInputStream != null;
                fileInputStream.close();
                assert readFile != null;
                readFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

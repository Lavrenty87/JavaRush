package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        BufferedReader reader;

        {
                try {
                    reader = new BufferedReader(new FileReader(Statics.FILE_NAME));
                    String a = reader.readLine();
                    while (a != null) {
                        lines.add(a);
                        a = reader.readLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}

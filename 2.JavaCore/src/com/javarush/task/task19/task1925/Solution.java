package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        BufferedReader bRF = null;
        BufferedWriter bWF = null;
        try {
            bRF = new BufferedReader(new  FileReader(args[0]));
            bWF = new BufferedWriter(new FileWriter(args[1]));
            ArrayList<String> listWords = new ArrayList<>();
            while (bRF.ready()) {
                String[] a = bRF.readLine().split("\\s");
                for (String s : a) {
                    if (s.length() > 6) listWords.add(s);
                }
            }
            for (int i = 0; i < listWords.size(); i++) {
                if (i == listWords.size() - 1) bWF.write(listWords.get(i));
                else bWF.write(listWords.get(i) + ",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                Objects.requireNonNull(bRF).close();
                Objects.requireNonNull(bWF).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

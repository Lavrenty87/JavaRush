package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

//D:\JavaRush\TeatTask2209\text.txt
public class Solution {
    public static void main(String[] args) {
        String a = null;
        try (FileReader reader = new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            int l;
            StringBuilder sb = new StringBuilder();
            while ((l = reader.read()) > 0) sb.append(((char) l));
            a = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] s = a.split(" ");
        StringBuilder result = getLine(s);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder s = new StringBuilder();
        ArrayList<String> strList = new ArrayList<>();


        for (int j = 0; j < words.length; j++){
            strList.addAll(Arrays.asList(words));
            s.delete(0, s.length());
            s.append(words[j]);
            strList.remove(words[j]);
            int count = 0;
            while (strList.size() > 0 && count < words.length) {
                for (int i = 0; i < strList.size(); i++) {
                    if (strList.get(i).toUpperCase().startsWith(s.substring(s.length()-1).toUpperCase())) {
                        s.append(" " + strList.get(i));
                        strList.remove(i);
                        break;
                    }
                }
                count++;
            }
            String[] a = s.toString().split(" ");
            if (a.length == words.length) break;
        }

        return s;
    }
}

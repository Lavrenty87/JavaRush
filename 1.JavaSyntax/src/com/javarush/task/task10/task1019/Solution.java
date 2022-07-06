package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        while (true) {
            try {
                String s = reader.readLine();
                //  if (s.equals("")) break;
                String id = reader.readLine();
                int name = Integer.parseInt(s);
                //   if (name.equals("")) break;
                map.put(id, name);
            }catch (Exception e){
                e.printStackTrace();
                for (HashMap.Entry<String, Integer> pair : map.entrySet()) {
                    String kay = pair.getKey();
                    Integer value = pair.getValue();
                    System.out.println(value + " " + kay);
                }break;
            }
        }

    }
}

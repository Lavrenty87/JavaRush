 package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

 import java.io.BufferedReader;
 import java.io.FileInputStream;
 import java.io.InputStreamReader;
 import java.util.*;

 public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> check = new HashSet<>();

        while (fis.available() > 0) {
            int a = fis.read();
            list.add(a);
            check.add(a);
        }
        fis.close();

        for (int i = 0 ; i < list.size(); i++) {
            if (check.contains(list.get(i))) {
                int data = 1;
                for (int j = i+1; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j))) data++;
                }
                map.put(list.get(i), data);
                check.remove(list.get(i));
            }
        }
        int min = Collections.max(map.values());
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == min) System.out.print(pair.getKey() + " ");
        }
    }
}

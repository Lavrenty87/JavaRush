package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> check = new HashSet<>();

        while (fis.available() > 0) {
            int a = fis.read();
            list.add(a);
            check.add(a);
        }

        br.close();
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
        int min = Collections.min(map.values());
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                if (pair.getValue() == min) System.out.print(pair.getKey() + " ");
            }
        }

        //Длинный способ

    /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> check = new HashSet<>();
        Map<Integer, Integer> result = new HashMap<>();

        reader.close();

        while (fis.available() > 0) {
            int a = fis.read();
            check.add(a);
            list.add(a);
        }

        fis.close();

        for (int i = 0; i < list.size() - 1; i++) {
            if (check.contains(list.get(i))) {
                int countRepeat = 1;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j))) {
                        countRepeat ++;
                    }
                    result.put(list.get(i), countRepeat);
                }
            }

            check.remove(list.get(i));
        }
        // пишу в лист ключи для удаления из мапы
        ArrayList<Integer> forDelete = new ArrayList<>();
        int lastCheck = result.get(list.get(0));
        for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
            Integer kai = pair.getKey();
            Integer value = pair.getValue();
            if (value > lastCheck) forDelete.add(kai);
            if (value < lastCheck) lastCheck = value;
        }
        //чишю мапу
        for (int a : forDelete) {
            result.remove(a);
        }
        //вывожу на экран
        for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
            Integer kai = pair.getKey();
            System.out.print(kai + " ");
        }*/

}

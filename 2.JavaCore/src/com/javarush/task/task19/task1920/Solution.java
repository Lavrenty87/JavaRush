package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> mapa = new TreeMap<>();
        BufferedReader buffRedFile = null;
        try {
            buffRedFile = new BufferedReader(new FileReader(args[0]));
            while (buffRedFile.ready()) {
                String line = buffRedFile.readLine();
                if (!line.isEmpty()) {
                    String[] splitLine = line.split(" ");
                    if (mapa.containsKey(splitLine[0])) {
                        mapa.put(splitLine[0], mapa.get(splitLine[0]) + Double.parseDouble(splitLine[1]));
                    } else mapa.put(splitLine[0], Double.parseDouble(splitLine[1]));
                }
            }
            double maxValueMap = Collections.max(mapa.values());
            for (Map.Entry<String, Double> hM : mapa.entrySet()) {
                String key = hM.getKey();
                double value = hM.getValue();
                if (value == maxValueMap) System.out.println(key);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert buffRedFile != null;
                buffRedFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

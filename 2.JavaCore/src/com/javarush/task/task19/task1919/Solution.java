package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/
//подвох с пустой строкий в файлею в условиях и примере не слово а валя проверяет
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;


public class Solution {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        TreeMap<String, Double> list = new TreeMap<>();
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(args[0]));

            while (fileReader.ready()) {
                String srt = fileReader.readLine();
                if (!srt.isEmpty()) {
                    String[] s = srt.split("\\s");
                    if (list.containsKey(s[0])){
                        list.put(s[0], list.get(s[0]) + Double.parseDouble(s[1]));
                    } else list.put(s[0], Double.parseDouble(s[1]));
                }
            }

            for (Map.Entry<String, Double> pir : list.entrySet()){
                String key = pir.getKey();
                Double value = pir.getValue();
                System.out.println(key + " " + value);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties propertiesOut = new Properties();
        propertiesOut.putAll(runtimeStorage);
        propertiesOut.store(outputStream, "comments");
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties propertiesIn = new Properties();
        propertiesIn.load(inputStream);
        propertiesIn.forEach((k, v) -> {runtimeStorage.put((String) k, (String) v);});
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            InputStream fis = new FileInputStream(fileName);
            OutputStream fos = new FileOutputStream(fileName);
                load(fis);
                save(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
    }
}

package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> fileNameList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit")) {
            fileNameList.add(fileName);
            fileName = reader.readLine();
        }
        for (String fN : fileNameList)
        new ReadThread(fN).start();
    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {

            HashMap<Integer, Integer> hashMapIntVIntC = new HashMap();
            InputStreamReader fis = null;
            try {
                fis = new InputStreamReader( new FileInputStream(fileName), Charset.defaultCharset());

                while (fis.ready()) {
                    int b = fis.read();
                    if (hashMapIntVIntC.isEmpty()) hashMapIntVIntC.put(b, 1);
                    if (hashMapIntVIntC.containsKey(b)) {
                        int values = hashMapIntVIntC.get(b).intValue();
                        values ++;
                        hashMapIntVIntC.replace(b, values);
                    } else hashMapIntVIntC.put(b, 1);
                }
                int maxValue = Collections.max(hashMapIntVIntC.values());
                for (Map.Entry<Integer, Integer> pai : hashMapIntVIntC.entrySet()) {
                    int key = pai.getKey();
                    int value = pai.getValue();
                    if (value == maxValue) {
                        resultMap.put(fileName, key);
                        System.out.println(fileName + " - " + key);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

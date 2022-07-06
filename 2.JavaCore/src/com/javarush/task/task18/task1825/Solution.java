package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> listFilePart = new TreeSet<>();
        String collectionFileName = null;

        String filePart = reader.readLine();
        while (!filePart.equals("end")) {
            listFilePart.add(filePart);
            filePart = reader.readLine();
        }
        reader.close();
        String[] result = listFilePart.first().split("\\.");


        for (int i = 0; i < result.length - 2; i++) {
            if (collectionFileName == null) collectionFileName = result[i];
            else collectionFileName += ("." + result[i]);
        }
        FileOutputStream fileOutputStream = new FileOutputStream(collectionFileName);

        for (String s : listFilePart) {
            FileInputStream fileInputStream = new FileInputStream(s);
            byte[] buff = new byte[1000];

            while (fileInputStream.available() > 0) {
                int count = fileInputStream.read(buff);
                fileOutputStream.write(buff, 0, count);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}

package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringBuilder sb = new StringBuilder();
            String result;
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
            writer.write(result);

        }
        return writer;
    }
}

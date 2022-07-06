package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName = reader.readLine();
            InputStreamReader isr = new InputStreamReader( new FileInputStream(fileName), Charset.defaultCharset());
            String s = null;

            while (isr.ready()) {
                if (s == null) s = String.valueOf((char) isr.read());
                else s = s + String.valueOf((char) isr.read());

            }
            isr.close();
            String [] sArr = s.split("\\n");
            for (int i = 0; i < sArr.length; i ++) {
                String[] arrChang = sArr[i].split(" ");
                if (args[0].equals(arrChang[0])) System.out.println(sArr[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

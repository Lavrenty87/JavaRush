package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String f1,f2;

            f1 = reader.readLine();
            f2 = reader.readLine();

            FileInputStream fis = new FileInputStream(f1);
            FileOutputStream fos = new FileOutputStream(f2);

            int i = 0;
            String a = null;
            while (fis.available() > 0) {
                if (a != " ") {
                    if (a == null) {
                        a = String.valueOf((char) fis.read());
                        i ++;
                    } else {
                        a = a + String.valueOf((char) fis.read());
                    }
                }
            }
            String[] arr =  a.split(" ");
            for (String v:arr
                 ) {
               long s = Math.round(Double.parseDouble(v));
               String l = String.valueOf(s) + " ";
                fos.write(l.getBytes());
            }

            reader.close();
            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine(),
                f2 = reader.readLine(),
                f3 = reader.readLine();
        int sizeF = 0;

        FileInputStream fsr = new FileInputStream(f1);
        FileOutputStream fos2 = new FileOutputStream(f2);
        FileOutputStream fos3 = new FileOutputStream(f3);
        System.out.println(fsr.available());
        if (fsr.available() % 2 == 0) {
            sizeF = fsr.available() / 2;
            System.out.println(sizeF);
        } else {
            sizeF = (int) (fsr.available() / 2 + 1);
            System.out.println(sizeF);
        }
        int i = 0;
        while (fsr.available() > 0) {
            if (i < sizeF) {
                fos2.write(fsr.read());
            }
            if (i > sizeF) {
                fos3.write(fsr.read());
            }
            i++;
        }
        fos2.close();
        fos3.close();
        fsr.close();
    }
}

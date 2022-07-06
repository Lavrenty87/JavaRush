package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] fileName = new String[3];
        fileName[0] = reader.readLine();
        fileName[1] = reader.readLine();
        fileName[2] = reader.readLine();

        FileOutputStream fos = new FileOutputStream(fileName[0]);
      //  FileOutputStream fosAdd = new FileOutputStream(fileName[0], true); дописыветь в поток можно и без этого если fos не закрывать раньше времени.
        FileInputStream fis = new FileInputStream(fileName[1]);
        FileInputStream fis2 = new FileInputStream(fileName[2]);

        byte[] bytes = new byte[1000];
        while (fis.available() > 0) {
            int count = fis.read(bytes);
            fos.write(bytes, 0, count);
        }


        byte[] bytes2 = new byte[1000];
        while (fis2.available() > 0) {
            int count = fis2.read(bytes2);
            // fosAdd.write(bytes2, 0, count); нет смысла поток не закрыт
            fos.write(bytes2, 0, count);
        }



        reader.close();
        fos.close();
       // fosAdd.close();
        fis.close();
        fis2.close();
    }
}

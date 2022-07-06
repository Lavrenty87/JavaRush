package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream rF = new FileInputStream(args[0]);
             FileOutputStream wF = new FileOutputStream(args[1])) {
            byte[] buff = new byte[rF.available()];
            rF.read(buff);
            String s = new String(buff, "Windows-1251");
            buff = s.getBytes(StandardCharsets.UTF_8);
            wF.write(buff);
        }

    }
}

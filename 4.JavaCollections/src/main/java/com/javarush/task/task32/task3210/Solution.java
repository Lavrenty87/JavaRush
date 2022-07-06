package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.

Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
Используй один из конструкторов класса String для конвертации считанной строчки в текст.
*/

public class Solution {
    public static void main(String... args) {

        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            raf.seek(Long.parseLong(args[1]));

            byte[] buffer = new byte[args[2].getBytes().length];
            raf.read(buffer, 0, buffer.length);
            String s = new String(buffer);
            String result = s.equals(args[2]) ? "true" : "false";
            raf.seek(raf.length());
            raf.write(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

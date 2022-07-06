package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String res = outputStream.toString();
       // String res = ress.substring(0, ress.length() - 2);
        System.setOut(consoleStream);
        String[] resArr = res.split("\\s");
        if (resArr[1].equals("+")) System.out.println(res + (Integer.parseInt(resArr[0]) + Integer.parseInt(resArr[2])));
        if (resArr[1].equals("-")) System.out.println(res + (Integer.parseInt(resArr[0]) - Integer.parseInt(resArr[2])));
        if (resArr[1].equals("*")) System.out.println(res + (Integer.parseInt(resArr[0]) * Integer.parseInt(resArr[2])));
        if (resArr[1].equals("/")) System.out.println(res + (Integer.parseInt(resArr[0]) / Integer.parseInt(resArr[2])));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


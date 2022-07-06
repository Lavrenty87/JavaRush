package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        String[] s = string.split(" ");
        if (s .length < 5) throw new TooShortStringException();
        String rez = s[1];
        for (int i = 2; i < 5; i++) rez += " " + s[i];//здесь был смысл StringBuffer или StringBuilder
        return rez;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}

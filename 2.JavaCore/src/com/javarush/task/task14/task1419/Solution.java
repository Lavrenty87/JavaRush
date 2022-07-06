package com.javarush.task.task14.task1419;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        //1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        //2
        try {
            String a = null;
            Scanner scanner = new Scanner(a);
        }catch (Exception e) {
            exceptions.add(e);
        }

        //3
        try {
            BufferedReader reader = new BufferedReader(new FileReader("0"));
        }catch (Exception e){
            exceptions.add(e);
        }

        //4
        try {
            int[] a = new int[5];
            a[5] = 6;
        }catch (Exception e) {
            exceptions.add(e);
        }

        //5
        try {
            ArrayList<String> os = new ArrayList<>();
            Object o = new Object();
            os.add(String.valueOf(o));

        } catch (Exception e) {
            exceptions.add(e);
        }

        //6
        try {
            String s = "fd25";
            Integer.parseInt(s);

        } catch (Exception e) {
            exceptions.add(e);
        }

        //7
        Object szStr[] = new String[10];

        try
        {
            szStr[0] = new Character('*');
        }catch (Exception e) {
            exceptions.add(e);
        }

        //8
        Object ch = new Character('*');
        try
        {
            System.out.println((Byte)ch);
        }catch (Exception e) {
            exceptions.add(e);
        }

        //9
        String s = "123";

        try
        {
            char chr = s.charAt(50);
        }catch (Exception e) {
            exceptions.add(e);
        }

        //10
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.close();
            reader.read();
        }catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Thread.sleep(-1);

        }catch ( Exception q){
            exceptions.add(q);
        }
    }
}

package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/
//

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = null, f2 = null;
        try {
            f1 = reader.readLine();
            f2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedReader readF = null;
        BufferedWriter writF = null;
        try {
            readF = new BufferedReader(new FileReader(f1));
            writF = new BufferedWriter(new FileWriter(f2));
            String strRead = null;
            while (readF.ready()) {
                if (strRead == null) strRead = String.valueOf((char) readF.read());
                else strRead += (String.valueOf((char) readF.read()));
            }
            String[] arr = strRead.split("\\s");
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].matches("\\b\\d+\\b")) writF.write(arr[i] + " ");
            }

//            ArrayList<Integer> list = new ArrayList<>();
//            for (String s : arr) {
//                try {
//                    list.add(Integer.parseInt(s));
//                }catch (NumberFormatException e) {
//                    e.printStackTrace();
//                }
//            }
//            for (int a = 0; a < list.size(); a++) {
//                if (a == list.size() - 1) writF.write(String.valueOf (list.get(a)));
//                else writF.write(list.get(a) + " ");
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert readF != null;
                readF.close();
                assert writF != null;
                writF.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

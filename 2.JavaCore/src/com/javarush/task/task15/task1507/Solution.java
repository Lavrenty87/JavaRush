package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
    //1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    //2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix((Integer) m, (Integer) n, (String) value);
    }
    //3
    public static void printMatrix(Integer m, Integer n, String value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
        printMatrix( (int)m, (int)n);
        printMatrix( (int)n, value);

    }
    //4
    public static void printMatrix (int m, int n) {
        System.out.println(m + ", " + n);
    printMatrix((Integer) m, (Integer) n);
    }
    //5
    public static void printMatrix (Integer m, Integer n) {
        System.out.println(m + ", " + n);
    printMatrix((int)m, n);
    }
    //6
    public static void printMatrix (int m, Integer n) {
        System.out.println(m + ", " + n);
    }
    //7
    public static void printMatrix (int n, String value) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(value);
            }
        }else System.out.println(value + " тут цкл не нужен " + n);
        printMatrix((Integer) n, value);
    }
    //8
    public static void printMatrix (Integer m, String value) {
        if (m > 0) {
            for (int i = 0; i < m; i++) {
                System.out.println(value);
            }
        }else System.out.println(value + " тут цкл не нужен " + m);
        printMatrix(m, (Object) value);
    }
    //9
    public static void printMatrix (Integer n, Object value) {
        int a = n;
        while (a != 0) {
            a--;
            System.out.println(value);
        }
        System.out.println(n);
        printMatrix((int) n, value);
    }
    //10
    public static void printMatrix (int n, Object value) {
        int a = n;
        while (a != 0) {
            a--;
            System.out.println(value);
        }
        System.out.println(n);
    }
}

package com.javarush.task.task26.task2601;

/*
Почитать в инете про медиану выборки
*/
//13, 15, 17, 8, 5

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public static void main(String[] args) {
        Integer[] arr = {13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static double getMedina (Integer[] array) {
        Arrays.sort(array);
        double rez;
        if (array.length %2==0) {
            rez = (double) (array[array.length/2-1] + array[array.length/2]) / 2 ;
        } else rez = array[array.length / 2];
        return rez;
    }

    public static Integer[] sort(Integer[] array) {
        final double medina = getMedina(array);

        Arrays.sort(array, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                double v1 = o1.intValue() - medina;
                double v2 = o2.intValue() - medina;
                int rez =  (int) ((v1*v1 - v2*v2) * 100);
                return rez;
            }
        });

        // плохое решение
       /* for (int i : array
             ) {
            System.out.print(i + ", ");
        }

        double med = 0;
        Arrays.sort(array);
        if (array.length %2==0) {
             med = (double) (array[array.length/2-1] + array[array.length/2]) / 2 ;
        } else med = array[array.length / 2];


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                double tempI = med - array[i];
                double tempJ = med - array[j];
                if (tempI < 0) tempI = tempI * -1;
                if (tempJ < 0) tempJ = tempJ * -1;
                if (tempI > tempJ) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }else if (tempI == tempJ) {
                    if (array[i] > array[j] ) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        System.out.println();
        for (int i : array) {
            System.out.print(i + ", ");
        }*/
        return array;
    }
}

package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            String[] arr = fileScanner.nextLine().split(" ");

            String strData = arr[3] + " " + arr[4] + " " + arr[5];   // !!! Важно пробелы между датой!!!!
            Date date = null;
            try {
                date = new SimpleDateFormat("dd MM yyyy", Locale.getDefault()).parse(strData);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(arr[1], arr[2], arr[0], date);
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}

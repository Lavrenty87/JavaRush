package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader readFile = new BufferedReader(new FileReader(args[0]));
        while (readFile.ready()) {
            String readFL = readFile.readLine();
            String[] arrReadFL = readFL.split("\\s");
            String name = null;
            String dB = null;
            for (String a : arrReadFL) {
                if (a.matches("\\b\\d+\\b")) {
                    if (dB == null) dB = a;
                    else dB += " " + a;
                } else {
                    if (name == null) name = a;
                    else name += " " + a;
                }
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = new Date();
            try {
                date = simpleDateFormat.parse(dB);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            PEOPLE.add(new Person(name, date));
        }
        readFile.close();
        for (Person a: PEOPLE) {
            System.out.println(a.getName() + " " + a.getBirthDate());
        }
    }
}

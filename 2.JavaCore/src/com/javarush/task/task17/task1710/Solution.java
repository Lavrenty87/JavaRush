package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args[0].equals("-c")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = dateFormat.parse(args[3]);
            if (args[2].equals("м")) {
                allPeople.add(Person.createMale(args[1], date));
            }
            else  {
                allPeople.add(Person.createFemale(args[1], date));
            }
            System.out.println(allPeople.size() - 1);
        }
        if (args[0].equals("-u")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date = dateFormat.parse(args[4]);
            if (args[3].equals("м")) {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.MALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(date);
            }
            if (args[3].equals("ж")) {
                allPeople.get(Integer.parseInt(args[1])).setName(args[2]);
                allPeople.get(Integer.parseInt(args[1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(date);
            }
        }
        if (args[0].equals("-d")) {
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        }
        if (args[0].equals("-i")) {
            String name = allPeople.get(Integer.parseInt(args[1])).getName();
            String sex = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String datd = sdf.format(allPeople.get(Integer.parseInt(args[1])).getBirthDate());
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE)) sex = "м";
            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE)) sex = "ж";
            System.out.println(name + " " + sex + " " + datd);// переопределить toString


        }
    }
}

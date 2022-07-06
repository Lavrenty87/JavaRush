package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    create(args);
                }
                break;
            case "-u" :
                synchronized (allPeople) {
                    upend(args);
                }
                break;
            case "-d" :
                synchronized (allPeople) {
                    dell(args);
                }
                break;
            case "-i" :
                synchronized (allPeople) {
                    info(args);
                }
                break;
        }
    }
        public static void create (String [] args) throws ParseException {
            for (int i = 1; i < args.length; i += 3) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = dateFormat.parse(args[i + 2]);
                if (args[i + 1].equals("м")) {
                    allPeople.add(com.javarush.task.task17.task1711.Person.createMale(args[i], date));
                } else {
                    allPeople.add(com.javarush.task.task17.task1711.Person.createFemale(args[i], date));
                }
                System.out.println(allPeople.size() - 1);
            }
        }
        public static void upend (String [] args) throws ParseException {
            for (int i = 1; i < args.length; i += 4) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = dateFormat.parse(args[i + 3]);
                if (args[i + 2].equals("м")) {
                    allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                    allPeople.get(Integer.parseInt(args[i])).setSex(com.javarush.task.task17.task1711.Sex.MALE);
                    allPeople.get(Integer.parseInt(args[i])).setBirthDate(date);
                }
                if (args[i + 2].equals("ж")) {
                    allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                    allPeople.get(Integer.parseInt(args[i])).setSex(com.javarush.task.task17.task1711.Sex.FEMALE);
                    allPeople.get(Integer.parseInt(args[i])).setBirthDate(date);
                }
            }
        }
        public static void dell (String [] args) {
            for (int i = 1; i < args.length; i ++) {
                allPeople.get(Integer.parseInt(args[i])).setName(null);
                allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                allPeople.get(Integer.parseInt(args[i])).setSex(null);
            }
        }
    public static void info (String [] args) {
        for (int i = 1; i < args.length; i ++) {
            String name = allPeople.get(Integer.parseInt(args[i])).getName();
            String sex = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String datd = sdf.format(allPeople.get(Integer.parseInt(args[i])).getBirthDate());
            if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(com.javarush.task.task17.task1711.Sex.MALE))
                sex = "м";
            if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE)) sex = "ж";
            System.out.println(name + " " + sex + " " + datd);// переопределить toString
        }
    }
}


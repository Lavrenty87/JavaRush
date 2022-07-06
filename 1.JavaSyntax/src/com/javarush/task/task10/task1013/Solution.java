package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name, surName, otchectvo;
        private int arg;
        private boolean sex;
        private String adres;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String surName) {
            this.name = name;
            this.surName = surName;
        }

        public Human(String name, String surName, int arg) {
            this.name = name;
            this.surName = surName;
            this.arg = arg;
        }

        public Human(String name, String surName, int arg, boolean sex) {
            this.name = name;
            this.surName = surName;
            this.arg = arg;
            this.sex = sex;
        }

        public Human(String name, String surName, int arg, boolean sex, String adres) {
            this.name = name;
            this.surName = surName;
            this.arg = arg;
            this.sex = sex;
            this.adres = adres;
        }

        public Human(String name, String surName, String otchectvo) {
            this.name = name;
            this.surName = surName;
            this.otchectvo = otchectvo;
        }

        public Human(String name, String surName, String otchectvo, int arg) {
            this.name = name;
            this.surName = surName;
            this.otchectvo = otchectvo;
            this.arg = arg;
        }

        public Human(String name, String surName, String otchectvo, boolean sex) {
            this.name = name;
            this.surName = surName;
            this.otchectvo = otchectvo;
            this.sex = sex;
        }

        public Human(String name, String surName, String otchectvo, int arg, boolean sex) {
            this.name = name;
            this.surName = surName;
            this.otchectvo = otchectvo;
            this.arg = arg;
            this.sex = sex;
        }

        public Human(String name, String surName, String otchectvo, int arg, boolean sex, String adres) {
            this.name = name;
            this.surName = surName;
            this.otchectvo = otchectvo;
            this.arg = arg;
            this.sex = sex;
            this.adres = adres;
        }
    }
}

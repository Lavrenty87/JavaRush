package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {

    }

    class Cat implements Movable, Edible, Eat {
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }

        @Override
        public void eat() {

        }
    }

    class Dog implements Movable, Eat {
        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }

    class Mouse implements Movable, Edible {
        @Override
        public void move() {

        }

        @Override
        public void beEaten() {

        }
    }

    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Edible {
        void beEaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
}
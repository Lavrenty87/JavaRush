package com.javarush.task.task20.task2017;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            return (A) objectStream.readObject();
            /* навертел из-за того что отлавливал только IOException и ClassNotFoundException
            A a = (A) objectStream.readObject();
            if (a.getClass() == A.class) return a;
            else return null;*/
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}

package com.javarush.task.task15.task1518;

/* 
Статики и котики
*/

public class Solution {
    public static Cat cat;
    static {
        cat = new Cat();
        cat.setName("ddfwr");
        System.out.println(cat.name);
    }

    public static void main(String[] args) {

    }
     public static class Cat {
        public String name;

         public void setName(String name) {
             this.name = name;
         }
     }
}

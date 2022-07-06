package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    static class StringObject implements SimpleObject<String> {//надо указывать пораметр вместо <T> когда имплементируешь интерфейс.
        private String a;

        @Override
        public  SimpleObject<String> getInstance() {
            this.a = a;
            return this;
        }
    }

}
